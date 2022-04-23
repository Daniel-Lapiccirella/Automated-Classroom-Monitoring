package com.automated.automatedclassroommonitoring.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.automated.automatedclassroommonitoring.R
import com.automated.automatedclassroommonitoring.models.BottomNavItem
import com.automated.automatedclassroommonitoring.ui.components.BottomNavigationBar
import com.automated.automatedclassroommonitoring.ui.components.HomeCards
import com.automated.automatedclassroommonitoring.ui.components.TopBar
import com.automated.automatedclassroommonitoring.ui.theme.IceBerg
import com.automated.automatedclassroommonitoring.ui.theme.YaleBlue
import com.automated.automatedclassroommonitoring.viewmodels.ACMViewModel

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun WeatherScreen(viewmodel: ACMViewModel, navController: NavController) {


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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            HomeCards(
                degree = viewmodel.temp.observeAsState().value.toString(),
                humidity = viewmodel.hum.observeAsState().value.toString(),
                isTemp = true,
                attendance = "",
                viewmodel = viewmodel
            )

            Card(
                shape = RoundedCornerShape(7.dp),
                backgroundColor = IceBerg,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .wrapContentSize(),
                border = BorderStroke(4.dp, YaleBlue)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (viewmodel.temp.observeAsState().value!! < 27) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_cold),
                                contentDescription = "cold",
                                modifier = Modifier
                                    .size(350.dp)
                                    .padding(15.dp)
                            )
                            Text(
                                text = "Chilly Temperature",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(5.dp)
                            )
                        } else if (viewmodel.temp.observeAsState().value!! in 28..29) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                                contentDescription = "Hot",
                                modifier = Modifier
                                    .size(350.dp)
                                    .padding(15.dp)
                            )
                            Text(
                                text = "Ideal Temperature",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(5.dp)
                            )


                        } else {

                            Image(
                                painter = painterResource(id = R.drawable.ic_humidity),
                                contentDescription = "Humid",
                                modifier = Modifier
                                    .size(350.dp)
                                    .padding(15.dp)
                            )
                            Text(
                                text = "Very Humid",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(5.dp)
                            )


                        }

                    }
                }
            }
        }
    }
}


//@ExperimentalMaterialApi
//@ExperimentalFoundationApi
//@Composable
//@Preview
//fun WeatherPreview() {
//    WeatherScreen(ACMViewModel())
//}