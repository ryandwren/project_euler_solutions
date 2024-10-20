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
    val firstHalf = num.toString().substring(0, num.toString().length/2) //will round down for odd length numbers
    val halfNextPal = firstHalf.toInt() -1

    if (halfNextPal.toString().length < firstHalf.length){
        //todo  we've lost a digit and need to adapt since mirroring will drop 2 digits.

    }



    var nextPal = num.toString().replaceRange(0, firstHalf.length, firstHalf)
    nextPal = nextPal.replaceRange(num.toString().length - firstHalf.length, num.toString().length, firstHalf.reversed())

    //todo if nextPal greater then input num call findNextPal again
    //This happens with the first input generated from the max val.



    return nextPal.toInt()
}
