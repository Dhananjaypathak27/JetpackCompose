package com.inxparticle.jetpackcompose

import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inxparticle.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        MakeUi()
        }
    }

@Composable
    fun MakeUi(){
        val painter = painterResource(id = R.drawable.meni)
        val contentDescriptor = "menions says woww"
        val title = "menions says woww"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ImageCard(painter = painter, contentDescriptor = contentDescriptor, title = title)
        }

    }


    @Composable
    fun ImageCard(
        painter: Painter,
        contentDescriptor: String,
        title: String,
        modifier: Modifier = Modifier
    ) {

        Card(
            modifier = modifier.fillMaxSize(0.4f),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red)
            ) {
                Image(
                    painter = painter,
                    contentDescription = contentDescriptor,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 300f
                            )
                        )
                ) {

                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(title, style = TextStyle(fontSize = 16.sp, color = Color.White))
                }
            }
        }

    }

    @Preview
    @Composable
    fun PreviewImageCard() {
        MakeUi()
    }
}

