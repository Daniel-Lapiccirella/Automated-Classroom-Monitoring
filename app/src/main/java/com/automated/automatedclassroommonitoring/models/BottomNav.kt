package com.automated.automatedclassroommonitoring.models

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: Painter
)

data class TopNavItem(
    val name: String,
    val route: String
)