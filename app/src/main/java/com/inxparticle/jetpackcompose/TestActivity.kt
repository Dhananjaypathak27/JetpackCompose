package com.inxparticle.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TestActivity :ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Color.Red)
                .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "hello Android", color = Color.Blue, fontSize = 25.sp)
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "hello Dhananjay Pathak", color = Color.Blue, fontSize = 25.sp)
                Box(modifier = Modifier.background(Color.Green).fillMaxWidth(), contentAlignment = Alignment.CenterEnd){
                    Button(modifier = Modifier.padding(end = 20.dp), onClick = {
                        Toast.makeText(applicationContext, "you have clicked on button", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "my Button ")
                    }
                }

            }
        }
    }

    @Preview
    @Composable
    fun MyComp() {
        Text(text = "this is")
    }

    @Preview
    @Composable
    fun MyCompp() {
        Text(text = "this isis the ")
    }
}