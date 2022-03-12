package com.automated.automatedclassroommonitoring.ui.components

import android.widget.EditText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.automated.automatedclassroommonitoring.ui.Greeting
import com.automated.automatedclassroommonitoring.ui.theme.AutomatedClassroomMonitoringTheme

@Composable
fun OnboardingCard(
    isLogin: Boolean,
    inputFields: List<String>
) {

    Card(
        shape = MaterialTheme.shapes.medium
    ) {

        Column {
            inputFields.forEachIndexed { index, title ->


                Text(
                    text = title,
                    color = Black,
                    style = MaterialTheme.typography.h6
                )
                EditTextComponent()
            }

        }
    }
}

@Composable
fun EditTextComponent() {
    Surface(color = Color.White, modifier = Modifier.padding(16.dp)) {
        var textValue by remember { mutableStateOf(TextFieldValue("Enter your text here")) }
        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // Update value of textValue with the latest value of the text field
            onValueChange = {
                textValue = it
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    OnboardingCard(isLogin = false, inputFields = listOf("Email", "Password"))

}
