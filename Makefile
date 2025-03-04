# Phony targets to avoid conflicts with files of the same name
.PHONY: default check test report treport lines md all kover diktat c m a t re r l d h

# Run code quality checks and apply formatting
check c:
	./gradlew spotlessApply spotlessCheck spotlessKotlin detekt ktlintCheck diktatCheck buildHealth --profile --daemon

# Default target: run checks and update README.md
default:
	make check && make md

# Update README.md with main and detekt report content
md m:
	truncate -s0 README.md && cat config/main.md >> README.md && cat build/reports/detekt/detekt.md >> README.md

# Run checks, build the project, and update README.md
all a:
	make check && ./gradlew build && md

# Run tests
test t:
	./gradlew test

# Generate JaCoCo test coverage report
report re:
	./gradlew jacocoTestReport

# Run tests and generate JaCoCo test coverage report
treport r:
	make test & make report

# Count lines of Kotlin code
lines l:
	find . -name '*.kt' | xargs wc -l

# Generate Kover HTML report
kover:
	./gradlew koverHtmlReport

# Run Diktat code style checks
diktat d:
	./gradlew diktatCheck

# Run build health checks
health h:
	./gradlew buildHealth

detekt:
	./gradlew detekt

# Set the default target
.DEFAULT_GOAL := default
