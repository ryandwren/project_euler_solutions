package com.ryandwren.project_euler_solutions.problems

import androidx.core.util.toHalf
import kotlin.math.pow

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of
two 2-digit numbers is 9009 = 91 times 99.
Find the largest palindrome made from the product of two 3-digit numbers.
*/

fun calcLargestPalindrome(digits: Int): Int{
    val max = (((10.0.pow(digits))-1).pow(2)).toInt()

    findNextPalindrome(max)


    return 10
}

fun findNextPalindrome(num: Int): Int{
    var nextPal = ""
    val input = num.toString()
    val inputIsEvenLength = input.length.rem(2) == 0



    val halfLength = num.toString().length /2 //will round down for odd length numbers

    //If num is odd length we need to include the center digit to subtract then mirror.
    val firstHalf = num.toString().substring(0, (halfLength + if (inputIsEvenLength) 0 else 1))
    val firstHalfNextPal = firstHalf.toInt() -1

    if (inputIsEvenLength){
        //input is even, we can split and mirror.
        if (firstHalfNextPal.toString().length < firstHalf.length){
            //we've lost a digit and need to adapt since mirroring will drop 2 digits.
            //Just add a 9 in between the first and end half.
            nextPal = firstHalfNextPal.toString() + "9" + firstHalfNextPal.toString().reversed()
        } else {
            nextPal = firstHalfNextPal.toString() + firstHalfNextPal.toString().reversed()
        }

    } else {
        //input is odd, we need to mirror the beginning of the half ignoring the last digit which we fold on.
        //When we subtract 1 from the halfNextPal we are ok with loosing a digit.
        if (firstHalfNextPal.toString().length < firstHalf.length){
            //we lost 1 digit and can just flip to get next palindrome. Ex: 10001 is now 9999.
            nextPal = firstHalfNextPal.toString() + firstHalfNextPal.toString().reversed()
        } else {
            //Because we have the center digit as part of the first half we need to flip on the last digit of the first half so its not duplicated.
            nextPal = firstHalfNextPal.toString() + firstHalfNextPal.toString().substring(0, firstHalfNextPal.toString().length-1).reversed()
        }
    }

    //Error for odd numbers, the center digit is being ignored, when next pal is changing center digit not two on either side of it.
    //Ex: 10101 next pal is 10001 not what this produces which is 919. (validate??)
    /*var nextPal = num.toString().replaceRange(0, firstHalf.length, firstHalf)
    nextPal = nextPal.replaceRange(num.toString().length - firstHalf.length, num.toString().length, firstHalf.reversed())*/

    //todo if nextPal greater then input num call findNextPal again
    //This happens with the first input generated from the max val.
    while (nextPal.toInt() > num){
        nextPal = findNextPalindrome(nextPal.toInt()).toString()
    }

    return nextPal.toInt()
}
