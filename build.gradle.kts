import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

val projectJvmTarget = 17
val satisfyingNumberOfCores = Runtime.getRuntime().availableProcessors().div(2).takeIf { it > 0 } ?: 1
val kotlinVersion = KOTLIN_2_0

fun isLinux(): Boolean {
    val osName = System.getProperty("os.name").lowercase()
    return listOf("linux", "mac os", "macos").contains(osName)
}

@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    base
    application
    jacoco
    idea
    alias(libs.plugins.kt.jvm)
    alias(libs.plugins.detekt)
    alias(libs.plugins.dokka)
    alias(libs.plugins.spotless)
    alias(libs.plugins.dependency.analysis)
    alias(libs.plugins.pitest)
    alias(libs.plugins.kover)
    alias(libs.plugins.diktat)
    alias(libs.plugins.ktlint)
}

jacoco {
    toolVersion = "0.8.12"
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.kotlin.link") }
    gradlePluginPortal()
    maven("https://plugins.gradle.org/m2/")
}

application {
    mainClass.set("link.kotlin.scripts.Application")
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    debug.set(true)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    outputColorName.set("RED")
    ignoreFailures.set(true)
    enableExperimentalRules.set(true)
    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
        reporter(ReporterType.JSON)
        reporter(ReporterType.HTML)
    }
    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

diktat {
    inputs {
        include("src/main/**/*.kt")
        exclude("**/generated/**")
    }
}

pitest {
    jvmArgs.set(listOf("-Xmx8192m"))
    avoidCallsTo.set(setOf("kotlin.jvm.internal", "kotlin.Result"))
    targetClasses.set(setOf("dev.shtanko.*"))
    targetTests.set(setOf("dev.shtanko.*"))
    pitestVersion.set("1.15.0")
    verbose.set(true)
    timestampedReports.set(false)
    threads.set(System.getenv("PITEST_THREADS")?.toInt() ?: satisfyingNumberOfCores)
    outputFormats.set(setOf("XML", "HTML"))
    testPlugin.set("junit5")
    junit5PluginVersion = "1.2.1"
    setWithHistory(true)
    mutationThreshold.set(40)
}

spotless {
    kotlin {
        target(
            fileTree(
                mapOf(
                    "dir" to ".",
                    "include" to listOf("**/*.kt"),
                    "exclude" to listOf("**/build/**", "**/spotless/*.kt"),
                ),
            ),
        )
        trimTrailingWhitespace()
        leadingTabsToSpaces()
        endWithNewline()
        val delimiter = "^(package|object|import|interface|internal|@file|//startfile)"
        val licenseHeaderFile = rootProject.file("spotless/copyright.kt")
        licenseHeaderFile(licenseHeaderFile, delimiter)
    }
}

subprojects {
    apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
}

kover {
    reports {
        verify {
            rule {
                minBound(80)
            }
        }
    }
}

tasks {
    withType<Test> {
        maxParallelForks = 1
        jvmArgs(
            "--add-opens",
            "java.base/jdk.internal.misc=ALL-UNNAMED",
            "--add-exports",
            "java.base/jdk.internal.util=ALL-UNNAMED",
            "--add-exports",
            "java.base/sun.security.action=ALL-UNNAMED",
        )
    }
    compileKotlin {
        compilerOptions {
            apiVersion.set(kotlinVersion)
            languageVersion.set(kotlinVersion)
        }
    }
    kotlin {
        jvmToolchain(projectJvmTarget)
    }
    jacocoTestCoverageVerification {
        violationRules {
            rule {
                limit {
                    minimum = "0.5".toBigDecimal()
                }
            }
        }
    }

    register<Copy>("copyGitHooks") {
        description = "Copies the git hooks from scripts/git-hooks to the .git folder."
        group = "git hooks"
        from("$rootDir/scripts/git-hooks/") {
            include("**/*.sh")
            rename("(.*).sh", "$1")
        }
        into("$rootDir/.git/hooks")
    }

    register<Exec>("installGitHooks") {
        description = "Installs the pre-commit git hooks from scripts/git-hooks."
        group = "git hooks"
        workingDir(rootDir)
        commandLine("chmod")
        args("-R", "+x", ".git/hooks/")
        dependsOn(named("copyGitHooks"))
        onlyIf {
            isLinux()
        }
        doLast {
            logger.info("Git hooks installed successfully.")
        }
    }

    register<Delete>("deleteGitHooks") {
        description = "Delete the pre-commit git hooks."
        group = "git hooks"
        delete(fileTree(".git/hooks/"))
    }

    afterEvaluate {
        tasks["clean"].dependsOn(tasks.named("installGitHooks"))
    }

    jacocoTestReport {
        dependsOn(test)
        reports {
            listOf(
                html,
                xml,
                csv,
            ).forEach { it.required.set(true) }
        }
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            apiVersion.set(KOTLIN_2_0)
        }
    }

    withType<io.gitlab.arturbosch.detekt.Detekt> {
        description = "Runs over whole code base without the starting overhead for each module."
        parallel = true
        baseline.set(file("$rootDir/config/detekt/detekt-baseline.xml"))
        config.from(file("config/detekt/detekt.yml"))
        jvmTarget = "$projectJvmTarget"

        setSource(files("src/main/kotlin", "src/test/kotlin"))
        setOf(
            "**/*.kt",
            "**/*.kts",
            ".*/resources/.*",
            ".*/build/.*",
            "/versions.gradle.kts",
        ).forEach {
            include(it)
        }

        reports {
            reports.apply {
                listOf(xml, html, txt, md).forEach { it.required.set(true) }
            }
        }
    }

    withType<DetektCreateBaselineTask> {
        jvmTarget = "$projectJvmTarget"
    }

    withType<Test>().configureEach {
        jvmArgs =
            listOf(
                "-Dkotlintest.tags.exclude=Integration,EndToEnd,Performance",
            )
        testLogging {
            events("passed", "skipped", "failed")
        }
        testLogging.showStandardStreams = true
        useJUnitPlatform()
        finalizedBy(withType(JacocoReport::class.java))
    }
}

kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.apply {
            listOf(
                "-Xexpect-actual-classes",
                "-Xwhen-guards",
                "-Xnon-local-break-continue",
                "-Xmulti-dollar-interpolation",
            ).forEach(::add)
        }
        apiVersion.set(KOTLIN_2_0)
        languageVersion.set(KOTLIN_2_0)
    }
}

dependencies {
    testRuntimeOnly("org.junit.platform:junit-platform-launcher") { because("required for pitest") }
    libs.apply {
        kotlin.apply {
            implementation(stdlib)
            runtimeOnly(reflect)
            compileOnly(coroutines)
        }
        testImplementation(mockk)
        testImplementation(assertj)
        junit.apply {
            testImplementation(api)
            testImplementation(params)
        }
        mockito.apply {
            // testImplementation(mockito) // not under usage for now
            // testImplementation(mockito.kotlin) // not under usage for now
        }
    }
}
