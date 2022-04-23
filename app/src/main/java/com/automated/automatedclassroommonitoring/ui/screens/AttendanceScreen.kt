package com.automated.automatedclassroommonitoring.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.automated.automatedclassroommonitoring.R
import com.automated.automatedclassroommonitoring.models.BottomNavItem
import com.automated.automatedclassroommonitoring.ui.components.BottomNavigationBar
import com.automated.automatedclassroommonitoring.ui.components.ExpandableCard
import com.automated.automatedclassroommonitoring.ui.components.TopBar
import com.automated.automatedclassroommonitoring.ui.theme.IceBerg
import com.automated.automatedclassroommonitoring.ui.theme.YaleBlue
import com.automated.automatedclassroommonitoring.viewmodels.ACMViewModel

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun AttendanceScreen(viewmodel: ACMViewModel, navController: NavController) {
    Scaffold(
        topBar = { TopBar(navController, true) },
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = "home",
                        icon = painterResource(id = R.drawable.ic_baseline_home_24)
                    ),
                    BottomNavItem(
                        name = "Weather",
                        route = "weather",
                        icon = painterResource(id = R.drawable.ic_baseline_wb_sunny_24)
                    ),

                    BottomNavItem(
                        name = "Attendance",
                        route = "Attendance",
                        icon = painterResource(id = R.drawable.ic_baseline_class_24)
                    ),
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 15.dp,
            backgroundColor = YaleBlue,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(
                    "Attendance",
                    Modifier
                        .padding(all = 15.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h1,
                    fontSize = 25.sp
                )
                Card(
                    modifier = Modifier,
                    shape = RoundedCornerShape(0.dp),
                    backgroundColor = IceBerg
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 25.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Bottom
                    ) {


                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.9f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            ExpandableCard(
                                courseNumber = "CENG 320",
                                isAttendance = true,
                                listOfNames = viewmodel.listOfStudents,
                                settingsString = "",

                                )
                            ExpandableCard(
                                courseNumber = "CENG 355 (Inactive)",
                                isAttendance = true,
                                listOfNames = viewmodel.emptyClass,
                                settingsString = "",

                                )

                            ExpandableCard(
                                courseNumber = "CENG 360 (Inactive) ",
                                isAttendance = true,
                                listOfNames = viewmodel.emptyClass,
                                settingsString = "",

                                )
                            ExpandableCard(
                                courseNumber = "CENG 200 (Inactive) ",
                                isAttendance = true,
                                listOfNames = viewmodel.emptyClass,
                                settingsString = "",

                                )
                        }

                    }
                }
            }
        }


    }
}