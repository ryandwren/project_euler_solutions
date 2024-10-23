package com.ryandwren.project_euler_solutions.problems

/*
Question 5: Smallest Multiple

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible (divisible with no remainder) by all of the numbers from 1 to 20?
*/

fun calcSmallestMultiple(digits: Int){
    //To be evenly divisible we can multiply all numbers up to digits.
    //To get smallest num we can remove any num that divides into a bigger number on the list.
    val divisors = findArrayOfDivisors(digits)
}

fun findArrayOfDivisors(digits: Int): List<Int>{
    var divisors = (digits downTo 2).toList()
    for (div in divisors){
        var counter = div -1
        while (counter > 1){
            if (div.rem(counter) == 0){
                divisors = divisors.filterNot { it == counter }
            }
            counter--
        }
    }
    return divisors
}