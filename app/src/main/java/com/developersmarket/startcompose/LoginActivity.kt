package com.developersmarket.startcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developersmarket.startcompose.ui.theme.StartComposeTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme() {
                Surface() {
                    LoginScreen()

                }
            }
        }
    }

    private fun logged(username:String,password: String){
        if (username=="user" && password=="1234"){
            Toast.makeText(this,"Logged In!!",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this,"Wrong Credential",Toast.LENGTH_SHORT).show()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class) @Composable fun LoginScreen() {
        val username = remember {
            mutableStateOf("")
        }

        val password = remember {
            mutableStateOf("")
        }
        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp).verticalScroll(rememberScrollState())
                ,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                    text = "Hello Again",
                    color = Color.DarkGray,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold
            )
            Text(
                    text = "Welcome",
                    color = Color.DarkGray,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold
            )

            Text(
                    text = "Back",
                    color = Color.DarkGray,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                    value = username.value,
                    onValueChange = {
                        username.value = it
                    },
                    leadingIcon = {
                        Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = ""
                        )
                    },
                    label = {
                        Text(text = "Username")
                    },
                    placeholder = {
                        Text(text = "Enter Username")
                    },
                    modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    leadingIcon = {
                        Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = ""
                        )
                    },
                    label = {
                        Text(text = "Password")
                    },
                    placeholder = {
                        Text(text = "Enter Password")
                    },
                    modifier = Modifier.fillMaxWidth()
            )

            OutlinedButton(
                    onClick = {logged(username.value,password.value) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
            ) {
                Text(text = "Login")
            }
        }
    }

}