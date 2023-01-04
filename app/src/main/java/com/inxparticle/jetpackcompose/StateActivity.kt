package com.inxparticle.jetpackcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

class StateActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{

            var color = remember {
                mutableStateOf(Color.Red)
            }

            Column(Modifier.fillMaxSize()) {
                CounterScreen(
                    Modifier
                        .weight(1f)
                        .background(Color.Red)
                        .fillMaxSize()){
                    color.value = it
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(color.value))
            }
        }
    }

    @Composable
    fun CounterScreen(modifier: Modifier,
                      updateColor:(Color)-> Unit
    ){

        Box(modifier = modifier
            .clickable {
                updateColor(
                    Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(),1f)
                )
            }){

        }
    }


    @Preview
    @Composable
    fun PreviewCounterScreen(){
//        CounterScreen(modifier = Modifier,)
    }
}