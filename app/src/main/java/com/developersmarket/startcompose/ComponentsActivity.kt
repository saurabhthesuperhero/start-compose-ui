package com.developersmarket.startcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developersmarket.startcompose.ui.theme.StartComposeTheme
import com.developersmarket.startcompose.ui.theme.md_theme_light_primary

class ComponentsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme() {
                    ComponentsScreen()
            }
        }
    }

    @Composable fun ComponentsScreen() {
        val textBoxSingle = remember {
            mutableStateOf("")
        }
        val textBoxMulti = remember {
            mutableStateOf("")
        }

        val textBoxDate = remember {
            mutableStateOf("")
        }
        val textBoxTime = remember {
            mutableStateOf("")
        }

        val isCheckedOne = remember {
            mutableStateOf(true)
        }

        val isCheckedTwo = remember {
            mutableStateOf(false)
        }
        Column(
                modifier = Modifier
                    .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                    )
                    .fillMaxSize()
        ) {

            Text(
                    text = "UI Components",
                    fontSize = 24.sp,
                    color = md_theme_light_primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                    value = textBoxSingle.value,
                    onValueChange = {
                        textBoxSingle.value = it
                    },
                    label = {
                        Text(text = "SingleLine TextBox")
                    },
                    placeholder = {
                        Text(text = "Enter Text")
                    },
                    modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                    value = textBoxMulti.value,
                    onValueChange = {
                        textBoxMulti.value = it
                    },
                    label = {
                        Text(text = "MultiLine TextBox")
                    },
                    placeholder = {
                        Text(text = "Enter Text")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    singleLine = false,

                    )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                    value = textBoxDate.value,
                    onValueChange = {
                        textBoxDate.value = it
                    },
                    label = {
                        Text(text = "Date Selector")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_calendar_month_24),
                                contentDescription = "Calender Picker"
                        )
                    },
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                    value = textBoxTime.value,
                    onValueChange = {
                        textBoxTime.value = it
                    },
                    label = {
                        Text(text = "Time Selector")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_access_time_24),
                                contentDescription = "Time Picker"
                        )
                    },
            )


            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                    value = "",
                    onValueChange = {
                        //TODO
                    },
                    label = {
                        Text(text = "Single Select")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = ""
                        )
                    },
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                    value = "",
                    onValueChange = {
                        //TODO
                    },
                    label = {
                        Text(text = "Multi Select")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = ""
                        )
                    },
            )

            Row(horizontalArrangement = Arrangement.Center) {
                Switch(
                        checked = isCheckedOne.value,
                        enabled = true,
                        onCheckedChange = {
                            isCheckedOne.value = it
                        },
                        modifier = Modifier.padding(horizontal = 8.dp)
                )

                Switch(
                        checked = isCheckedTwo.value,
                        enabled = true,
                        onCheckedChange = {
                            isCheckedTwo.value = it
                        },
                        modifier = Modifier.padding(horizontal = 8.dp)

                )
            }

        }
    }


}