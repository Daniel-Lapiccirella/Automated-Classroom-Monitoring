package com.automated.automatedclassroommonitoring.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.automated.automatedclassroommonitoring.models.Students

@Composable
fun UpdatingList(listOfNames: MutableList<Students>) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(listOfNames) { student ->
            student.Student?.let {
                Text(
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.body1,
                    text = it
                )

            }
        }
    }

}