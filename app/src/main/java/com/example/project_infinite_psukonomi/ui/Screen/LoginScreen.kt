package com.example.project_infinite_psukonomi.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_infinite_psukonomi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Sign up Page",
                modifier = Modifier.padding(bottom = 80.dp),
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA16AE8),
                fontStyle = FontStyle.Italic
            )
            Image(
                painter = painterResource(id = R.drawable.imgp),
                contentDescription = "Img",
                Modifier.size(200.dp)
            )
        }
        Column {
            TextField(
                value = userName,
                placeholder = {
                    Text(text = "User name")
                },
                onValueChange = {
                    userName = it
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.background)
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            TextField(
                value = password,
                placeholder = {
                    Text(text = "Password")
                },
                onValueChange = {
                    password = it
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
        Spacer(modifier = Modifier.padding(top = 32.dp))
        Button(onClick = { }) {
            Text(text = "SignUp")
        }
    }
}