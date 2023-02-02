package com.developersmarket.startcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
            ProfileScreen()
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


@Composable fun MyApp() {
    MaterialTheme {
        ShowInfo()
    }

}

@Preview(showBackground = true) @Composable fun DefaultPreview() {
    StartComposeTheme {
        MyApp()
    }
}