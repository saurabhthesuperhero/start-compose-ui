package com.developersmarket.startcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developersmarket.startcompose.ui.theme.StartComposeTheme
import com.developersmarket.startcompose.ui.theme.md_theme_light_primary
import com.maxkeppeker.sheets.core.models.base.rememberSheetState

class ComponentsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme() {
                ComponentsScreen()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class) @Composable fun ComponentsScreen() {
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



        val (checkedState_1, onStateChange_1) = remember { mutableStateOf(true) }
        val (checkedState_2, onStateChange_2) = remember { mutableStateOf(true) }

        Column(
                modifier = Modifier
                    .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                    )
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
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

            Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
            ) {
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

            Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                        Modifier
                            .height(56.dp)
                            .toggleable(
                                    value = checkedState_1,
                                    onValueChange = { onStateChange_1(!checkedState_1) },
                                    role = Role.Checkbox
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                            checked = checkedState_1,
                            onCheckedChange = null // null recommended for accessibility with screenreaders
                    )
                    Text(
                            text = "CheckBox 1",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 16.dp)
                    )
                }

                Row(
                        Modifier
                            .height(56.dp)
                            .toggleable(
                                    value = checkedState_2,
                                    onValueChange = { onStateChange_2(!checkedState_2) },
                                    role = Role.Checkbox
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                            checked = checkedState_2,
                            onCheckedChange = null // null recommended for accessibility with screenreaders
                    )
                    Text(
                            text = "CheckBox 2",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 16.dp)
                    )
                }

            }


            Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                        onClick = { /* Do something! */ },
                        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                ) {
                    Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Like")
                }

                Button(onClick = { /* Do something! */ }) { Text("Button") }

            }
        }

    }
}


