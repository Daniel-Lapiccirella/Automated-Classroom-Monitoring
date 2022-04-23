package com.automated.automatedclassroommonitoring.ui.theme

import androidx.compose.material.ContentAlpha.medium
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.automated.automatedclassroommonitoring.R


val Roboto = FontFamily(

    Font(R.font.roboto_black,weight = FontWeight.ExtraBold),
    Font(R.font.roboto_bold,weight = FontWeight.Bold),
    Font(R.font.roboto_light,weight = FontWeight.Light),
    Font(R.font.roboto_medium, weight = FontWeight.Medium),
    Font(R.font.roboto_regular,weight = FontWeight.Normal),

    )


// Set of Material typography styles to start with
val Typography = Typography(

    h1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp),

    h2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp),

    h3 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp),

    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp),

    body2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp),








)