package com.developersmarket.startcompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class) @Preview @Composable fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
                name = "Saurabhthesuperhero",
                modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
                highlight = listOf(
                        ImageWithText(
                                painterResource(id = R.drawable.demo_img),
                                text = "Morning"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.demo_img),
                                text = "Afternoon"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.demo_img),
                                text = "Night"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.demo_img),
                                text = "Dance"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.demo_img),
                                text = "Yoga"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.demo_img),
                                text = "Karate"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.demo_img),
                                text = "Love"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.demo_img),
                                text = "Selfie"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.demo_img),
                                text = "Heart"
                        )


                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
                imageWithTexts = listOf(
                        ImageWithText(
                                painterResource(id = R.drawable.ic_baseline_border_all_24),
                                "Posts"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.ic_baseline_slow_motion_video_24),
                                "Reels"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.ic_baseline_live_tv_24),
                                "IGTV"
                        ),
                        ImageWithText(
                                painterResource(id = R.drawable.ic_baseline_person_24),
                                "Profile"
                        )
                )
        ) {
            selectedTabIndex = it

        }
        when (selectedTabIndex) {
            0 -> PostSection(
                    posts = listOf(
                            painterResource(id = R.drawable.pizza),
                            painterResource(id = R.drawable.img_1),
                            painterResource(id = R.drawable.img_2),
                            painterResource(id = R.drawable.img_3),
                            painterResource(id = R.drawable.img_4),
                            painterResource(id = R.drawable.img_5),
                            painterResource(id = R.drawable.img_1),
                            painterResource(id = R.drawable.img_2),
                            painterResource(id = R.drawable.img_3),
                            painterResource(id = R.drawable.img_4),
                            painterResource(id = R.drawable.img_5),
                    ),
                    modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable fun TopBar(
        name: String, modifier: Modifier = Modifier
) {
    Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
    ) {
        Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
        )
        Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
        )
        Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
        )
        Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
        )
    }

}

@Composable fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                    image = painterResource(id = R.drawable.robo),
                    modifier = Modifier
                        .size(100.dp)
                        .weight(3f)
//                        .fillMaxWidth()
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }

//        Spacer(modifier = Modifier.height(10.dp))
        ProfileDescription(
                displayName = "Saurabh Jadhav",
                description = "Life is about Life \nYou are about you, ok bye good night!",
                url = "https://saurabhjadhavblogs.com",
                followedBy = listOf(
                        "iamsrk",
                        "saraalikhan"
                ),
                otherCount = 18,
                modifier = Modifier.weight(1f)
        )

    }
}

@Composable fun RoundImage(
        image: Painter, modifier: Modifier = Modifier
) {
    androidx.compose.foundation.Image(
            painter = image,
            contentDescription = "",
            modifier = modifier
                .aspectRatio(
                        1f,
                        matchHeightConstraintsFirst = true
                )
                .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = CircleShape
                )
                .padding(3.dp)
                .clip(shape = CircleShape)
    )
}

@Composable fun StatSection(modifier: Modifier) {
    Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        ProfileStat(
                numberText = "800",
                text = "Posts"
        )
        ProfileStat(
                numberText = "501",
                text = "Followers"
        )
        ProfileStat(
                numberText = "100",
                text = "Following"
        )
    }
}

@Composable fun ProfileStat(numberText: String, text: String, modifier: Modifier = Modifier) {

    Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(horizontal = 8.dp)
    ) {
        Text(
                text = numberText,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)

    }
}

@Composable fun ProfileDescription(
        displayName: String, description: String, url: String, followedBy: List<String>, otherCount: Int, modifier: Modifier
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
    ) {
        Text(
                text = displayName,
                fontWeight = FontWeight.Bold,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
        )
        Text(
                text = description,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
        )
        Text(
                text = url,
                color = Color.Blue,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                    text = buildAnnotatedString {
                        val boldStyle = SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                        )
                        append("Followed by ")
                        pushStyle(boldStyle)
                        followedBy.forEachIndexed { index, s ->
                            pushStyle(boldStyle)
                            append(s)
                            pop()
                            if (index < followedBy.size - 1) {
                                append(", ")
                            }

                        }
                        if (otherCount > 2) {
                            append(" and ")
                            pushStyle(boldStyle)
                            append("$otherCount others")
                        }
                    },
                    letterSpacing = letterSpacing,
                    lineHeight = lineHeight
            )
        }

    }
}

@Composable fun ButtonSection(modifier: Modifier = Modifier) {

    val minWidth = 95.dp
    val height = 30.dp
    Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
    ) {
        ActionButton(
                text = "Following",
                icon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .defaultMinSize(minWidth)
                    .height(height)

        )
        ActionButton(
                text = "Message",
                icon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .defaultMinSize(minWidth)
                    .height(height)

        )

        ActionButton(
                text = "Email",
                modifier = Modifier
                    .defaultMinSize(minWidth)
                    .height(height)

        )
        ActionButton(
                icon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .defaultMinSize(minWidth)
                    .height(height)

        )
    }
}

@Composable fun ActionButton(
        modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null
) {
    Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(5.dp)
                )
                .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
            )
        }
        if (icon != null) Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
        )
    }

}

@Composable fun HighlightSection(modifier: Modifier = Modifier, highlight: List<ImageWithText>) {
    LazyRow(modifier = modifier) {
        items(highlight.size) {
            Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(
                        image = highlight[it].image,
                        modifier = Modifier.size(70.dp)
                )
                Text(
                        text = highlight[it].text,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable fun PostTabView(
        modifier: Modifier = Modifier, imageWithTexts: List<ImageWithText>, onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.Transparent,
            contentColor = Color.Black,
            modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->

            Tab(selected = selectedTabIndex == index,
                    selectedContentColor = Color.Black,
                    unselectedContentColor = inactiveColor,
                    onClick = {
                        selectedTabIndex = index
                        onTabSelected(index)
                    }) {
                Icon(
                        painter = item.image,
                        contentDescription = item.text,
                        tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(20.dp)
                )

            }

        }

    }

}

@ExperimentalFoundationApi @Composable fun PostSection(
        posts: List<Painter>, modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = modifier.scale(1.01f)

    ) {
        items(posts.size) {
            Image(
                    painter = posts[it],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .border(
                                width = 1.dp,
                                color = Color.White
                        )
            )
        }
    }
}








