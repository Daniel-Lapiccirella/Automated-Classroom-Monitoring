package com.automated.automatedclassroommonitoring.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {

    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            "About Us",
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 15.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h3,
            fontSize = 30.sp
        )



    }

    Column(verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start) {
        Text(
            "This app is to allow for teachers to easily monitor class attendance with no extra work. When students scan their id card it will show up on the class list. This about will also allow the teacher to monitor the weather inside the classroom",
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 15.dp),
            style = MaterialTheme.typography.body1,
            fontSize = 20.sp
        )
    }
}