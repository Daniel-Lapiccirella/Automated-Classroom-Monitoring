package com.automated.automatedclassroommonitoring.ui.nav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.automated.automatedclassroommonitoring.ui.screens.AttendanceScreen
import com.automated.automatedclassroommonitoring.ui.screens.HomeScreen
import com.automated.automatedclassroommonitoring.ui.screens.SettingsScreen
import com.automated.automatedclassroommonitoring.ui.screens.SplashScreen
import com.automated.automatedclassroommonitoring.ui.screens.WeatherScreen
import com.automated.automatedclassroommonitoring.viewmodels.ACMViewModel


@ExperimentalFoundationApi
@OptIn(ExperimentalMaterialApi::class)
@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    dataStore: DataStore<Preferences>,
    viewmodel: ACMViewModel,
) {
    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable(
            route = "home"
        ) { HomeScreen(viewmodel, navController = navController) }
        composable(
            route = "weather"
        ) { WeatherScreen(viewmodel, navController = navController) }
        composable(
            route = "Attendance"
        ) { AttendanceScreen(viewmodel, navController = navController) }
        composable(
            route = "Settings"
        ) { SettingsScreen(viewmodel, navController = navController) }
        composable(
            route = "SplashScreen"
        ) { SplashScreen(navController = navController) }

    }
}






