package com.inxparticle.jetpackcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class TextStylingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val family = FontFamily(
//            Font(R.font.poppins_bold, FontWeight.Bold),
//            Font(R.font.poppins_light, FontWeight.Light),
//            Font(R.font.poppins_extra_light, FontWeight.ExtraLight),
//            Font(R.font.poppins_medium, FontWeight.Medium),
//        )
        setContent {
            TextDecorationCustom()
        }
    }


    @Composable
    fun TextDecorationCustom() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFF101010))
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green,
                            fontSize = 50.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("J")
                    }
                    append("etpack ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green,
                            fontSize = 50.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    ){
                        append("C")
                    }
                    append("ompose")
                },
                style = TextStyle(color = Color.White, fontSize = 26.sp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                textDecoration = TextDecoration.LineThrough
            )
        }
    }

    @Preview
    @Composable
    fun PreviewTextDecoration() {
        TextDecorationCustom()
    }
}