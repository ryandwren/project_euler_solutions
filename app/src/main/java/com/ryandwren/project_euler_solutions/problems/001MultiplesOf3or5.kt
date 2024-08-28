package com.ryandwren.project_euler_solutions.problems

/*
Problem 1
Multiples of 3 or 5

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

fun solveTotalMultiples(firstMultiple:Int, secondMultiple:Int, limitNumber:Int){
    var listOfFirstMultiples = buildMultiplesList(firstMultiple, limitNumber)
    var listOfSecondMultiples = buildMultiplesList(secondMultiple, limitNumber)


}

fun buildMultiplesList(multiple:Int, limitNumber:Int): ArrayList<Int>{
    val listOfMultiples = ArrayList<Int>()
    var underLimit = true
    var currentValue = 0

    while (underLimit){
        currentValue += multiple
        if (currentValue < limitNumber){
            listOfMultiples.add(currentValue)
        } else {
            underLimit = false
        }
    }

    return listOfMultiples
}
