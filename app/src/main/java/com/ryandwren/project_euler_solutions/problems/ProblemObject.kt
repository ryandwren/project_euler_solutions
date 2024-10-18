package com.ryandwren.project_euler_solutions.problems

data class ProblemObject(
    val title: String,
    val calculate: () -> Any? = {},
    val calculateEulers: (() -> Any?)? = null,
    //var alternativeInputOne: Any? = null,
    //var alternativeInputTwo: Any? = null,
    //var answer: Any? = null,
    //var eulersAnswer: String? = null,
    //var timeToCompleteAnswer: Int? = null,
    //var timeToCompleteEulersAnswer: Int? = null,
    )
