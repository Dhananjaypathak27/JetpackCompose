package com.inxparticle.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class AnimantionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var size by remember{
                mutableStateOf(200.dp)
            }

            val animationSize by animateDpAsState(targetValue = size)

            Box(modifier = Modifier
                .size(animationSize)
                .background(Color.Red), contentAlignment = Alignment.Center){
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(onClick = {
                        size += 50.dp
                    }) {
                        Text(text = "Click to Increase")
                    }

                    Button(onClick = {
                        size -= 50.dp
                    }) {
                        Text(text = "Click to Decrease")
                    }
                }

            }
        }
    }
}