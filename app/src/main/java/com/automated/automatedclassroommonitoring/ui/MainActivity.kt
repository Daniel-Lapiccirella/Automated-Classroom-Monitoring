package com.automated.automatedclassroommonitoring.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Observer
import androidx.navigation.compose.rememberNavController
import com.automated.automatedclassroommonitoring.R
import com.automated.automatedclassroommonitoring.models.BottomNavItem
import com.automated.automatedclassroommonitoring.ui.components.BottomNavigationBar
import com.automated.automatedclassroommonitoring.ui.components.TopBar
import com.automated.automatedclassroommonitoring.ui.nav.SetupNavGraph
import com.automated.automatedclassroommonitoring.ui.screens.HomeScreen
import com.automated.automatedclassroommonitoring.ui.screens.SplashScreen
import com.automated.automatedclassroommonitoring.ui.theme.AutomatedClassroomMonitoringTheme
import com.automated.automatedclassroommonitoring.viewmodels.ACMViewModel

class MainActivity : ComponentActivity() {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    val viewModel: ACMViewModel by viewModels()

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            AutomatedClassroomMonitoringTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController,dataStore = LocalContext.current.dataStore, viewmodel = viewModel)


            }
        }
    }
}

