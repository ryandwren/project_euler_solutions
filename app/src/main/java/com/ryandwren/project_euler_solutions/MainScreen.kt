package com.ryandwren.project_euler_solutions

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.SelectionContainer
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryandwren.project_euler_solutions.problems.eulersAnswer
import com.ryandwren.project_euler_solutions.problems.solveTotalMultiples

@Composable
fun MainScreen(){

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            var expanded by remember { mutableStateOf(false) }
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .clickable {
                        expanded = !expanded
                    }
                    .padding(16.dp)
            ) {
                Text(
                    text = "Problem 1: Multiples of 3 or 5",
                    modifier = Modifier.weight(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.nav_arrow_down),
                    contentDescription = "min",
                    modifier = if (expanded) Modifier.rotate(180f) else Modifier
                )
            }

            AnimatedVisibility(visible = expanded) {
                var answer: Int? by remember{ mutableStateOf(null) }
                var eulersAnswer: Int? by remember{ mutableStateOf(null) }
                Column {
                    Button(
                        onClick = {
                            answer = solveTotalMultiples(
                                firstMultiple = 3,
                                secondMultiple = 5,
                                limitNumber = 1000
                            )
                            eulersAnswer = eulersAnswer(
                                firstMultiple = 3,
                                secondMultiple = 5,
                                limitNumber = 1000
                            )
                        },
                        content = {
                            Text(text = "Calculate" )
                        }
                    )
                    AnimatedVisibility(visible = (answer != null)) {
                        Column{
                            SelectionContainer {
                                Text(text = "My answer: " + answer.toString())
                            }
                            SelectionContainer {
                                Text(text = "Eulers answer: " + eulersAnswer.toString())
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = false, name = "Dark", uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL)
fun PreviewMainScreen(){
    MaterialTheme{
        MainScreen()
    }
}
