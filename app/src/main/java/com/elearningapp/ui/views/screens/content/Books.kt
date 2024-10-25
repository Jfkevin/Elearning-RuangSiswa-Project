package com.elearningapp.ui.views.screens.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.elearningapp.R
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun Books(navController: NavController) {
    // Remember the scroll state
    val scrollState = rememberScrollState()

    // Sample drawable resource IDs (replace with your actual drawable resource IDs)
    val imageResourceIds = listOf(
        R.drawable.bukufisika, // Replace with your drawable resource ID
        R.drawable.bukubiologi, // Replace with your drawable resource ID
        R.drawable.bukukimia  // Replace with your drawable resource ID
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .verticalScroll(scrollState) // Make the column scrollable
    ) {
        imageResourceIds.forEachIndexed() {index, imageResId ->
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if(index==0)
                        {
                            val link="https://drive.google.com/file/d/1UBA7qCZa6ldrcLhT5l_0hujgks1YEPUu/view?usp=drive_link"
                            navController.navigate(
                                "video_lesson/${
                                    URLEncoder.encode(
                                        link,
                                        StandardCharsets.UTF_8.toString()
                                    )
                                }"
                            )
                        }
                        else if(index==1)
                        {
                            val link="https://drive.google.com/file/d/1St-x_fi4bOuhZF2ygCjP4_Lc3Tg-IY1g/view?usp=drive_link"
                            navController.navigate(
                                "video_lesson/${
                                    URLEncoder.encode(
                                        link,
                                        StandardCharsets.UTF_8.toString()
                                    )
                                }"
                            )
                        }
                        else{
                            val link="https://drive.google.com/file/d/1FXpI2uOeXZXJgq_I94qMRsPEUiZj8sL7/view?usp=drive_link"
                            navController.navigate(
                                "video_lesson/${
                                    URLEncoder.encode(
                                        link,
                                        StandardCharsets.UTF_8.toString()
                                    )
                                }"
                            )
                        }
                    }
                    .height(400.dp) // Adjust the height as needed
                    .padding(8.dp), // Optional padding
                contentScale = ContentScale.FillBounds // Adjust the content scale as needed
            )
        }
    }
}
