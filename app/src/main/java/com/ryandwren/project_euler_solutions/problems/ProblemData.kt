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
    )
)