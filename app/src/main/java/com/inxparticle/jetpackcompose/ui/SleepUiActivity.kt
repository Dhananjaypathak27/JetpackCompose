package com.inxparticle.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.inxparticle.jetpackcompose.ui.theme.JetpackComposeTheme

class SleepUiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                HomeScreen()
            }
        }
    }


}