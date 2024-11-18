package com.ryandwren.project_euler_solutions.problems

data class ProblemObject(
    val title: String,
    val problemStatement: String? = null,
    val calculate: ((Any?) -> Any?)? = null,
    val calculateEulers: ((Any?) -> Any?)? = null,
    //var alternativeInputOne: Any? = null,
    //var alternativeInputTwo: Any? = null,
    //var answer: Any? = null,
    //var eulersAnswer: String? = null,
    //var timeToCompleteAnswer: Int? = null,
    //var timeToCompleteEulersAnswer: Int? = null,
    val sanitizeInput: ((String?) -> String?)? = null
    )
