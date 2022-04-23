package com.automated.automatedclassroommonitoring.viewmodels


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.automated.automatedclassroommonitoring.models.Students
import com.automated.automatedclassroommonitoring.models.Temperature
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class ACMViewModel(
) : ViewModel() {

    private val database = Firebase.database
    val listOfStudents = mutableStateListOf<Students>()
    val emptyClass = mutableListOf<Students>(Students(Student = "No Students Attending"))

    private var _temp = MutableLiveData<Int>()
    var temp: LiveData<Int> = _temp

    private var _hum = MutableLiveData<Int>()
    var hum: LiveData<Int> = _hum


    init {

        listOfStudents.clear()
        Log.d("test", listOfStudents.toString())
        dataBaseStudentConnection()
        dataBaseTempConnection()
    }

    private fun dataBaseStudentConnection() {

        database.getReference("Students").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val value = dataSnapshot.children.last().getValue<Students>()
                if (value != null && !listOfStudents.contains(value)) {
                    listOfStudents.add(value)
                }
                Log.d("TESTING", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

    private fun dataBaseTempConnection() {
        database.getReference("Temperature").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val value = dataSnapshot.children.last().getValue<Temperature>()
                if (value != null) {
                    _hum.postValue(value.humidity)
                    _temp.postValue(value.temp)
                }
                Log.d("TESTING", "Value is: $value")
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })
    }

}
