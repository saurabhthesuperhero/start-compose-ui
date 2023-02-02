package com.developersmarket.startcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developersmarket.startcompose.ui.theme.StartComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ProfileScreen()

            StartComposeTheme() {
                Scaffold(topBar = {
                    TopAppBar(title = { Text(text = "My App") },
                            navigationIcon = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "Menu"
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                            imageVector = Icons.Default.Notifications,
                                            contentDescription = "Noti"
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = "Search"
                                    )
                                }
                            })


                },
                        floatingActionButton = {
                            FloatingActionButton(onClick = { }) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription = "Add"
                                    )
                                }
                            }
                        },
                        floatingActionButtonPosition = FabPosition.Center
                ) {
                    ShowSwitch()
                }
            }
        }
    }
}

@Composable fun ShowInfo() {
    Card(
            elevation = 4.dp,
            modifier = Modifier.padding(16.dp)
    ) {
        Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
        ) {
            Row {
                Box {
                    Image(
                            painter = painterResource(id = R.drawable.demo_img),
                            contentDescription = "",
                            modifier = Modifier
                                .size(size = 60.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.FillBounds

                    )
//                    Icon(imageVector = Icons.Default.Person, contentDescription = "")

                }
                Row(modifier = Modifier.padding(horizontal = 8.dp)) {
                    Text(text = "Name: ")
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Saurabh")
                }

            }

        }
    }
}


@Preview(showBackground = true) @Composable fun DefaultPreview() {
    StartComposeTheme {}
}

@Composable fun ShowSwitch() {
    val isChecked= remember {
        mutableStateOf(true )
    }
    Switch(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value=it
            },
            modifier = Modifier.run {
                size(20.dp)
                padding(10.dp)
            }
    )
}




















