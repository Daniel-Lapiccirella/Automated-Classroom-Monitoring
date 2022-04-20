package com.automated.automatedclassroommonitoring.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.automated.automatedclassroommonitoring.ui.theme.IceBerg
import com.automated.automatedclassroommonitoring.ui.theme.YaleBlue
import com.automated.automatedclassroommonitoring.viewmodels.ACMViewModel

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun WeatherCard(viewmodel: ACMViewModel) {
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
                .padding(top = 15.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Outdoor Climate",
                Modifier
                    .padding(bottom = 15.dp, start = 10.dp)
                    .fillMaxWidth(),

                )
            Card(
                modifier = Modifier,
                shape = RoundedCornerShape(0.dp),
                backgroundColor = IceBerg,

                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ExpandableCard(courseNumber = "CENG 320", listOfNames = viewmodel.listOfStudents)

                }   //End of Lazy Vert Grid Scope
            }//End of Row Scope
        }//End of Card Scope
    }//End of Column Scope
}//End of Main Card Scope


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
@Preview
fun WeatherCardPreview() {
    WeatherCard(ACMViewModel())
}