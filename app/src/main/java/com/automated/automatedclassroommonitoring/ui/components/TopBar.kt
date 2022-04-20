package com.automated.automatedclassroommonitoring.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.automated.automatedclassroommonitoring.R
import com.automated.automatedclassroommonitoring.ui.theme.YaleBlue


@Composable
fun TopBar(
navController: NavController


) {
    TopAppBar(
        title = {
            Text(text = "ACM", color = Color.White, modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
                )},
        backgroundColor = YaleBlue,
        actions = {
            IconButton(onClick = { navController.navigate( "Settings") } ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                    contentDescription = "Settings"
                    )
            }
        }
    )
}

@Composable
@Preview
fun TopBarPreview() {

}