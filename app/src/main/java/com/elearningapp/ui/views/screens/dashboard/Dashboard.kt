package com.elearningapp.ui.views.screens.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.elearningapp.R
import com.elearningapp.ui.theme.blue
import com.elearningapp.viewmodel.DashboardViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Dashboard(navcontroller: NavController) {
    val viewModel: DashboardViewModel = viewModel()
    val scrollState1 = rememberScrollState()
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                IconButton(onClick = { },
                    modifier = Modifier
                        .padding(top=5.dp, start = 15.dp, bottom=5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ruangsiswa),
                        contentDescription = "Logo Image",
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = " Hello Learners!",
                    modifier = Modifier
                        .padding(top=5.dp,bottom=5.dp),
                    style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Medium, color = Color.Black),
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White,
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 8.dp
            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription = "Home",
                            tint = if (selectedTab == 0) blue else Color.Gray
                        )
                    },
                    label = { Text("Home",color = if (selectedTab == 0) blue else Color.Gray) },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Filled.Book,
                            contentDescription = "Books",
                            tint = if (selectedTab == 1) blue else Color.Gray
                        )
                    },
                    label = { Text("Books",color = if (selectedTab == 1) blue else Color.Gray) },
                    selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                        navcontroller.navigate("books")
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Filled.Description,
                            contentDescription = "Papers",
                            tint = if (selectedTab == 2) blue else Color.Gray
                        )
                    },
                    label = { Text("Papers",color = if (selectedTab == 2) blue else Color.Gray) },
                    selected = selectedTab == 2,
                    onClick = {
                        selectedTab = 2
                        val link="https://drive.google.com/drive/folders/1eC3W8VhgiFHp6VY0LPkff4FX6QZY_Fbs?usp=drive_link"
                        navcontroller.navigate(
                            "video_lesson/$${URLEncoder.encode(link, StandardCharsets.UTF_8.toString())}"
                        )
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Filled.Info,
                            contentDescription = "About",
                            tint = if (selectedTab == 3) blue else Color.Gray
                        )
                    },
                    label = { Text("About", color = if (selectedTab == 3) blue else Color.Gray) },
                    selected = selectedTab == 3,
                    onClick = {
                        selectedTab = 3
                        navcontroller.navigate("about_us")
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = "Lessons",
                            tint = if (selectedTab == 4) blue else Color.Gray
                        )
                    },
                    label = { Text("Lessons", color = if (selectedTab == 4) blue else Color.Gray) },
                    selected = selectedTab == 4,
                    onClick = {
                        selectedTab = 4
                        navcontroller.navigate("lesson_form")
                    }
                )
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState1)
                    .fillMaxSize(),
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                SearchBar(navcontroller)
                CourseList(navcontroller)

                ContentText(first = "Popular Lessons", second ="See All", call="popular", navcontroller)
                CourseCard(navcontroller)

                ContentText(first = "AR Learning", second ="See All", call="ar", navcontroller)
                AssessmentCard(navcontroller)

                Button(
                    onClick = { navcontroller.navigate("lesson_form") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Go to Lesson Form")
                }
            }
        }
    )
}
