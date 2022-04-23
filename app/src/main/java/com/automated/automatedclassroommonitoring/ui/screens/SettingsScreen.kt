package com.automated.automatedclassroommonitoring.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.automated.automatedclassroommonitoring.ui.components.ExpandableCard
import com.automated.automatedclassroommonitoring.ui.components.TopBar
import com.automated.automatedclassroommonitoring.viewmodels.ACMViewModel

@ExperimentalMaterialApi
@Composable
fun SettingsScreen(viewmodel: ACMViewModel, navController: NavController) {

    Scaffold(
        topBar = { TopBar(navController, false) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {


            ExpandableCard(
                courseNumber = "About Us",
                listOfNames = viewmodel.listOfStudents,
                isAttendance = false,
                settingsString = "I have Developed Automatic Classroom Monitoring to allow for teachers and students to have a stress free method of tracking their attendance in the the classroom and to allow teachers too easily monitor the temperature in the room. This app was developed by Daniel Lapiccirella",

                )
            ExpandableCard(
                courseNumber = "Help",
                listOfNames = viewmodel.listOfStudents,
                isAttendance = false,
                settingsString = "If there is any problems you may encounter while using Automated Classroom Monitoring, or anything you would like to recommend send an email to daniel2lapiccirella@gmail.com",

                )
        }
    }


}



