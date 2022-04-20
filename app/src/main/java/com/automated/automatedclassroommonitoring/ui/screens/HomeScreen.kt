package com.automated.automatedclassroommonitoring.ui.screens

import android.content.Context
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavController
import com.automated.automatedclassroommonitoring.R
import com.automated.automatedclassroommonitoring.models.BottomNavItem
import com.automated.automatedclassroommonitoring.ui.components.BottomNavigationBar
import com.automated.automatedclassroommonitoring.ui.components.HomeCards
import com.automated.automatedclassroommonitoring.ui.components.TopBar
import com.automated.automatedclassroommonitoring.ui.nav.SetupNavGraph
import com.automated.automatedclassroommonitoring.viewmodels.ACMViewModel
import androidx.activity.viewModels
import androidx.navigation.NavHostController


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
//val viewModel : ACMViewModel by viewModels()

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(viewmodel: ACMViewModel, navController: NavController) {


    Scaffold(
        topBar = { TopBar(navController) },
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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            HomeCards(
                degree = viewmodel.temphum.last().temp.toString(),
                humidity = viewmodel.temphum.last().humidity.toString(),
                isTemp = true,
                attendance = "",
                viewmodel = ACMViewModel()
            )

            HomeCards(
                degree = "50",
                humidity = "55",
                isTemp = false,
                attendance = "",
                viewmodel = ACMViewModel()
            )
        }

    }
}


//@ExperimentalMaterialApi
//@Composable
//@Preview
//fun HomeCardTempPreview() {
//    HomeScreen(ACMViewModel())
//}