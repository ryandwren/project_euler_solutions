package com.ryandwren.project_euler_solutions.problems

import kotlin.math.pow

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of
two 2-digit numbers is 9009 = 91 times 99.
Find the largest palindrome made from the product of two 3-digit numbers.
*/

fun calcLargestPalindrome(digits: Int): Int {
    val fullDigits = (10.0.pow(digits)) - 1 //the highest number in that digit range. EX: 3 = 999.
    val max = ((fullDigits.toFloat()).pow(2)).toInt()
    var nextPal = findNextPalindrome(max)

    while (true) {
        var divider = fullDigits //start at top and work our way down.
        while (nextPal.rem((divider).toInt()) != 0) {
            if (nextPal.div(divider).toInt() > fullDigits) {
                //This pal won't work, reset and check next pal.
                divider = fullDigits
                nextPal = findNextPalindrome(nextPal)
            } else {
                divider--
            }
        }

        //Now we have a number divisible by our pal, but need to check if it's divider is in range.
        val secondDivider = (nextPal / (divider)).toInt().toString()
        if (secondDivider.length != digits) {
            //Not a valid divider (both need to be the user specified digits long)
            //Reset and check next pal. Since while block loops again we don't need to reset divider.
            nextPal = findNextPalindrome(nextPal)
        } else {
            break //use break instead of setting while variable to false to leave the loop.
        }
    }

    return nextPal
}

fun findNextPalindrome(num: Int): Int {
    val halfLength = num.toString().length / 2 //will round down for odd length numbers
    val inputIsEvenLength = num.toString().length.rem(2) == 0

    //If num is odd length we need to include the center digit to subtract then mirror.
    val firstHalf = num.toString().substring(0, (halfLength + if (inputIsEvenLength) 0 else 1))
    val firstHalfNextPal = firstHalf.toInt() - 1

    //If we subtracted 1 from a 0 and lost a digit we need to prevent loosing 2 digits on rebuild.
    var nextPal = if (firstHalfNextPal.toString().length < firstHalf.length) {
        //Even length pals will loose 2 digits and we need to add one missing digit as a 9. Odds don't have this issue.
        firstHalfNextPal.toString() + if (inputIsEvenLength) "9" else "" + firstHalfNextPal.toString().reversed()
    } else {
        //When building our mirror we need to flip around the center digit for odd length pals without duplicating it.
        firstHalfNextPal.toString() +
                if (inputIsEvenLength)
                    firstHalfNextPal.toString().reversed()
                else
                    firstHalfNextPal.toString().substring(0, firstHalfNextPal.toString().length - 1).reversed()
    }

    //If nextPal greater then input num call findNextPal again.
    //Happens with the first input generated from the max val.
    while (nextPal.toInt() > num) {
        nextPal = findNextPalindrome(nextPal.toInt()).toString()
    }

    return nextPal.toInt()
}

fun eulersCalcLargestPalindrome(digits: Int): Int{
    //todo this only works with 3 digits.
    val fullDigits = (10.0.pow(digits)) - 1 //the highest number in that digit range. EX: 3 = 999.

    var nextPal = 0
    var divider = fullDigits.toInt() //a
    var secondDivider = 0 //b
    var factor = 0 //db

    while (divider > 100){
        if (divider.rem(11) == 0){
            secondDivider = fullDigits.toInt()
            factor = 1
        } else {
            secondDivider = fullDigits.toInt() - 11
            factor = 11
        }

        innerLoop@ while (secondDivider >= divider){
            if (divider * secondDivider <= nextPal){
                break@innerLoop //intended break pattern?
            }
            if (isPalindrome((divider * secondDivider))){
                nextPal = divider * secondDivider
            }
            secondDivider -= factor
        }
        divider -= 1
    }
    return nextPal
}

fun eulersIsPalindrome(number:Int):Boolean{
    var num = number
    var reversedNum = 0
    while (num > 0){
        reversedNum = 10 * reversedNum + num.rem(10) //todo this give strange results when number ends in 0.
        num /= 10
    }
    return number == reversedNum
}

fun isPalindrome(num: Int): Boolean{
    val halfLength = num.toString().length / 2 //will round down for odd length numbers
    val inputIsEvenLength = num.toString().length.rem(2) == 0
    val firstHalf = num.toString().substring(0, (halfLength + if (inputIsEvenLength) 0 else 1))
    val reversed = firstHalf +
            if (inputIsEvenLength)
                firstHalf.reversed()
            else
                firstHalf.substring(0, firstHalf.length - 1).reversed()

    return num == reversed.toInt()
}