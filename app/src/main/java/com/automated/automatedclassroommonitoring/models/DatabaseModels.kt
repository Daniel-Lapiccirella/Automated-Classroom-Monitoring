package com.automated.automatedclassroommonitoring.models

import com.google.gson.annotations.SerializedName

data class Students(
    val Student : String? = null
)

data class Temperature(
    val humidity: Int? = null,
    val temp: Int? = null
)