package com.inxparticle.jetpackcompose

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

class LoadingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val coroutine = rememberCoroutineScope()
            TestingCompose()
        }
    }

    @Composable
    fun TestingCompose() {
        val counter1 = remember {
            mutableStateOf(1)
        }
        object : CountDownTimer(20000, 1000) {

            override fun onTick(p0: Long) {
                counter1.value++
            }

            override fun onFinish() {

            }

        }.start()

        Surface(color = Color.Red) {
            Box(Modifier.fillMaxSize()) {
                if (counter1.value < 5)
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                if (counter1.value > 5) {
                    Text(
                        text = "timer finish",
                        modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

}

