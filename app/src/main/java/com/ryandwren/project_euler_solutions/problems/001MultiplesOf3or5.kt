package com.ryandwren.project_euler_solutions.problems

/*
Problem 1
Multiples of 3 or 5

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

/*
Solved by Ryan Wren for the first time on 8-30-24
*/


fun solveTotalMultiples(firstMultiple:Int, secondMultiple:Int, limitNumber:Int): Int{
    val listOfFirstMultiples = buildMultiplesList(firstMultiple, limitNumber)
    val listOfSecondMultiples = buildMultiplesList(secondMultiple, limitNumber)
    val listOfMutualMultiples = calculateMutualMultiples(firstMultiple, listOfSecondMultiples, limitNumber)

    //Mutual multiples appear in both lists. Subtract once to remove repeated count.
    return (listOfFirstMultiples.sum() + listOfSecondMultiples.sum()) - listOfMutualMultiples.sum()
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

fun calculateMutualMultiples(firstMultiple:Int, listOfSecondMultiples:ArrayList<Int>, limitNumber:Int): ArrayList<Int>{
    val listOfDuplicates = ArrayList<Int>()
    var currentMultiple = 0

    for (secondMultipleItem in listOfSecondMultiples){
        currentMultiple = firstMultiple * secondMultipleItem
        if (currentMultiple < limitNumber){
            listOfDuplicates.add(currentMultiple)
        } else{
            break
        }
    }

    return listOfDuplicates
}

fun eulersAnswer(firstMultiple:Int, secondMultiple:Int, limitNumber:Int): Int {
    val firstSum = eulersCalcMultipleSum(firstMultiple, limitNumber)
    val secondSum = eulersCalcMultipleSum(secondMultiple, limitNumber)
    val mutualSum = eulersCalcMultipleSum((firstMultiple * secondMultiple), limitNumber)

    return firstSum + secondSum - mutualSum
}

fun eulersCalcMultipleSum(multiple:Int, limitNumber:Int): Int {
    val numOfMultiples = (limitNumber -1) / multiple
    return (multiple * (numOfMultiples * (numOfMultiples+1))) /2
}
