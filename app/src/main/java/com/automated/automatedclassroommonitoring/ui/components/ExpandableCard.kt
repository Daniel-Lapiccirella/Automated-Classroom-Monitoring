package com.automated.automatedclassroommonitoring.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.automated.automatedclassroommonitoring.models.Students
import com.automated.automatedclassroommonitoring.ui.theme.Shapes
import com.automated.automatedclassroommonitoring.ui.theme.SteelBlue

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    courseNumber: String,
    listOfNames: MutableList<Students>,
    isAttendance: Boolean,
    settingsString: String,
    shape: Shape = Shapes.medium,
    padding: Dp = 12.dp,
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )



    Card(
        backgroundColor = SteelBlue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandedState = !expandedState
        },

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = courseNumber,
                    style = MaterialTheme.typography.h2,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            if (expandedState) {
                if (isAttendance) {
                    UpdatingList(listOfNames)
                } else {
                    Text(
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.body1,
                        text = settingsString,
                        modifier = Modifier.padding(5.dp)
                    )


                }
            }
        }
    }
}











