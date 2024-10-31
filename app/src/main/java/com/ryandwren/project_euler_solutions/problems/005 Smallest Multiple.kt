package com.ryandwren.project_euler_solutions.problems

/*
Question 5: Smallest Multiple

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible (divisible with no remainder) by all of the numbers from 1 to 20?
*/

fun solveP5SmallestMultiple(digits: Int): Int {
    val divisors = (2..digits).toList()
    val solutionFactorList = ArrayList<Int>()

    for (div in divisors){
        val divFactors = findPrimeFactorizationList(div.toULong())
        for (fac in divFactors){
            while (divFactors.count { it == fac } > solutionFactorList.count { it == fac }){
                solutionFactorList.add(fac)
            }
        }
    }

    return solutionFactorList.reduce{ acc, num -> acc * num}
}

private fun isDivisibleByRange(num: Int, digits: Int): Boolean {
    val divisors = (digits downTo 2).toList()
    for (div in divisors) {
        if (num.rem(div) != 0) {
            return false
        }
    }
    return true
}