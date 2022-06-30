package com.example.imagecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagecard.ui.theme.ImageCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.harry)
            val desc = "One of my best Series!"
            val title = "Harry Potter"
            Box(modifier = Modifier
                .fillMaxSize(0.5f)
                .padding(16.dp)
            ) {
                ImageCard(
                    painter = painter,
                    contentDesc =desc,
                    title = title
                )
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDesc: String,
    title: String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
       Box(modifier = Modifier.height(200.dp)) {
           Image(
               painter = painter,
               contentDescription = contentDesc,
               contentScale = ContentScale.Crop
           )
           Box(modifier = Modifier
               .fillMaxSize()
               .background(
                   brush = Brush.verticalGradient(
                       colors = listOf(
                           Color.Transparent,
                           Color.Black
                       ),
                       startY = 300f
                   )
               ))
           Column {


               Box(
                   modifier = Modifier
                       .fillMaxSize()
                       .padding(12.dp),
                   contentAlignment =  Alignment.BottomStart
               ) {
                   Text(contentDesc, style = TextStyle(color = Color.White, fontSize = 16.sp))
               }
           }

       }
    }
}