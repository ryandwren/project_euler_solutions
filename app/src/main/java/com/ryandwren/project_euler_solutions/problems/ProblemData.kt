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
        calculate = {
            return@ProblemObject calcLargestPrimeFactor(600851475143UL)
        }
    )
)