package com.automated.automatedclassroommonitoring.viewmodels


import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.automated.automatedclassroommonitoring.models.Student
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
    val listOfStudents = mutableListOf<Student>()


    val temphum = mutableListOf<Temperature>()

    init {
        temphum.add(Temperature(24, 23))
        listOfStudents.clear()
        dataBaseStudentConnection()
        dataBaseTempConnection()
    }

    private fun dataBaseStudentConnection() {
        database.getReference("Student").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val value = dataSnapshot.children.last().getValue<Student>()
                if (value != null) {
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
                    temphum[0] = value
                }
                Log.d("TESTING", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })
    }

}
