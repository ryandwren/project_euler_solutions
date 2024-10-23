package com.ryandwren.project_euler_solutions.problems

val problemData = listOf(
    ProblemObject(
        title = "Problem 1: Multiples of 3 or 5",
        calculate = {
            return@ProblemObject solveTotalMultiples(
                firstMultiple = 3,
                secondMultiple = 5,
                limitNumber = 1000
            )
        }
    ),
    ProblemObject(
        title = "Problem 2: Even Fibonacci Numbers",
        calculate = {
            return@ProblemObject calcEvenFibonacciNumbers()
        }
    ),
    ProblemObject(
        title = "Problem 3: Largest Prime Factor",
        calculate = {  override: Any? ->
            return@ProblemObject calcLargestPrimeFactor(override.toString().toULongOrNull() ?: 600851475143UL)
        },
        calculateEulers = { override: Any? ->
            return@ProblemObject eulersCalcLargestPrimeFactor(override.toString().toULongOrNull() ?: 600851475143UL)
        },
        sanitizeInput = { input ->
            return@ProblemObject input?.take(20)?.filter { it.isDigit() }
        }
    ),
    ProblemObject(
        title = "Problem 4: Largest Palindrome Product",
        calculate = { override: Any? ->
            return@ProblemObject calcLargestPalindrome(override.toString().toIntOrNull() ?: 3)

        },
        calculateEulers = { override: Any? ->
            return@ProblemObject eulersCalcLargestPalindrome(override.toString().toIntOrNull() ?: 3)
        },
        sanitizeInput = { input ->
            //This is number of digits so past 9 digits is too big.
            return@ProblemObject input?.take(1)?.filter { it.isDigit() }
        }
    ),
    ProblemObject(
        title = "Question 5: Smallest Multiple",
        calculate = {
            return@ProblemObject calcSmallestMultiple(20)
        }
    )
)