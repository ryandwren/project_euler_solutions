package com.ryandwren.project_euler_solutions

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ryandwren.project_euler_solutions.problems.solveTotalMultiples

@Composable
fun MainScreen(){
    var answer: Int? by remember{ mutableStateOf(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                answer = solveTotalMultiples(
                    firstMultiple = 3,
                    secondMultiple = 5,
                    limitNumber = 1000
                )
            },
            content = {
                Text(text = "Problem 1" )
            }
        )
        AnimatedVisibility(visible = (answer != null)) {
            Text(text = answer.toString())
        }
    }
}

@Composable
@PreviewLightDark
fun PreviewMainScreen(){
    MaterialTheme{
        MainScreen()
    }
}
