package com.automated.automatedclassroommonitoring.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.automated.automatedclassroommonitoring.ui.theme.IceBerg
import com.automated.automatedclassroommonitoring.ui.theme.YaleBlue
import com.automated.automatedclassroommonitoring.viewmodels.ACMViewModel

@ExperimentalMaterialApi
@Composable
fun HomeCards(
    degree: String,
    humidity: String,
    attendance: String,
    isTemp: Boolean,
    viewmodel: ACMViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 15.dp,
        backgroundColor = YaleBlue,
    )
    {
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
        ) {
            if (isTemp) {
                Text(

                    "Room Climate",
                    Modifier
                        .padding(bottom = 15.dp, start = 10.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h1,
                    fontSize = 30.sp
                )
                Card(
                    shape = RoundedCornerShape(0.dp),
                    backgroundColor = IceBerg
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = "Temperature",
                                style = MaterialTheme.typography.h2,
                                fontSize = 20.sp
                            )
                            Text(
                                text = "Humidity",
                                style = MaterialTheme.typography.h2,
                                fontSize = 20.sp
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 25.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = "$degree°C",
                                style = MaterialTheme.typography.h3,
                                fontSize = 25.sp
                            )
                            Text(
                                text = "$humidity%",
                                style = MaterialTheme.typography.h3,
                                fontSize = 25.sp
                            )
                        }
                    }
                }
            } else {
                Text(
                    "Attendance",
                    Modifier
                        .padding(bottom = 15.dp, start = 10.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h1,
                    fontSize = 30.sp
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

                        ExpandableCard(
                            courseNumber = "CENG 320",
                            listOfNames = viewmodel.listOfStudents,
                            isAttendance = true,
                            settingsString = "",


                            )

                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun HomeCardTempPreview() {
    HomeCards(degree = "55", humidity = "55", attendance = "", isTemp = true, ACMViewModel())
}