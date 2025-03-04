```kotlin

sealed interface Complexity {
  /**
   * O(1)
   * Provides an unvarying execution time, no matter how much input you provide.
   * Each input requires a single unit of execution time.
   */
  data object Constant : Complexity()

  /**
   * O(log n)
   * The number of operations grows at a slower rate than the input,
   * making the algorithm less efficient with small inputs and more efficient with larger ones.
   * A typical algorithm of this class is the binary search.
   */
  data object Logarithmic : Complexity()

  /**
   * O(n)
   * Operations grow with the input in a 1:1 ratio.
   * A typical algorithm is iteration, when you scan input once and apply an operation to each element of it.
   */
  data object Linear : Complexity()

  /**
   * O(n log n)
   * Complexity is a mix between logarithmic and linear complexity.
   * It is typical of some smart algorithms used to order data, such as Mergesortsort, Heapsort, and Quicksort.
   */
  data object Linearithmic : Complexity()

  /**
   * O(n2)
   * Operations grow as a square of the number of inputs.
   * When you have one iteration inside another iteration (called nested iterations in computer science),
   * you have quadratic complexity. For instance, you have a list of names and,
   * in order to find the most similar ones, you compare each name against all the other names.
   * Some less efficient ordering algorithms present such complexity: bubble sort, selection sort, and insertion sort.
   * This level of complexity means that your algorithms may run for hours or even days before reaching a solution.
   */
  data object Quadratic : Complexity()

  /**
   * O(n3)
   * Operations grow even faster than quadratic complexity because now you have multiple nested iterations.
   * When an algorithm has this order of complexity and you need to process a modest amount of data (100,000 elements),
   * your algorithm may run for years. When you have a number of operations that is a power of the input,
   * it is common to refer to the algorithm as running in polynomial time.
   */
  data object Cubic : Complexity()

  /**
   * O(2n)
   * The algorithm takes twice the number of previous operations for every new element added.
   * When an algorithm has this complexity, even small problems may take forever.
   * Many algorithms doing exhaustive searches have exponential complexity.
   * However, the classic example for this level of complexity is the calculation of Fibonacci numbers.
   */
  data object Exponential : Complexity()

  /**
   * O(n!)
   * This algorithm presents a real nightmare of complexity because of the large number of possible combinations
   * between the elements. Just imagine: If your input is 100 objects,
   * and an operation on your computer takes 10-6 seconds (a reasonable speed for every computer nowadays),
   * you will need about 10140 years to complete the task successfully (an impossible amount of time because the
   * age of the universe is estimated as being 1014 years). A famous factorial complexity problem is the traveling
   * salesman problem, in which a salesman has to find the shortest route for visiting many cities
   * and coming back to the starting city.
   */
  data object Factorial : Complexity()
}

```
