package com.example.uireportissues

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uireportissues.ui.theme.UIReportIssuesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            UIReportIssuesTheme {

                Surface(color = MaterialTheme.colorScheme.background) {

                    ReportIssueScreen()

                }

            }
        }
    }
}


@Composable
fun ReportIssueScreen() {

    // var title by remember { mutableStateOf("") }
    // var description by remember { mutableStateOf("") }
    // Initialize state variables.

    var title by remember { mutableStateOf(TextFieldValue()) }
    var description by remember { mutableStateOf(TextFieldValue()) }
    var message by remember { mutableStateOf("") }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(

        modifier = Modifier

            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center

    ){

        Text(text = "Report an Issue", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(

            value = title,

            onValueChange = { title = it },

            label = { Text("Title") },

            singleLine = true,

            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(

            value = description,

            onValueChange = { description = it },

            label = { Text("Description") },

            singleLine = false,

            modifier = Modifier

                .fillMaxWidth()
                .height(150.dp)

        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(

            modifier = Modifier.fillMaxWidth(),

            onClick = {

                // Handle the submission logic here

                message = "Issue reported: ${title.text}"



            },

            // modifier = Modifier.align(LineHeightStyle.Alignment.End)

        ) {

            Text("Submit")

        }

        Spacer(modifier = Modifier.height(16.dp))

        if (message.isNotEmpty()) {

            Text(

                text = message,
                color = MaterialTheme.colorScheme.primary

            )

        }

    }

}


@Preview(showBackground = true)
@Composable
fun ReportIssueScreenPreview() {

    UIReportIssuesTheme {

        ReportIssueScreen()

    }

}






