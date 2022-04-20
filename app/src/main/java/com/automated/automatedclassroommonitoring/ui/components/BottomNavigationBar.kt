package com.automated.automatedclassroommonitoring.ui.components


import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.automated.automatedclassroommonitoring.R
import com.automated.automatedclassroommonitoring.models.BottomNavItem
import com.automated.automatedclassroommonitoring.ui.nav.SetupNavGraph
import com.automated.automatedclassroommonitoring.ui.screens.dataStore
import com.automated.automatedclassroommonitoring.ui.theme.SafetyOrange
import com.automated.automatedclassroommonitoring.viewmodels.ACMViewModel




@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = SafetyOrange,
                unselectedContentColor = Color.White,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = item.icon,
                            contentDescription = item.name,
                        )
                        Text(
                            text = item.name,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )
                    }

                })
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
@Preview
fun BottomNavPreview() {
    BottomNavigationBar(items = listOf(
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
        navController = rememberNavController(),
        onItemClick = {}
    )
}