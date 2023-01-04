package com.inxparticle.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class TextFieldAndSnackBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val textField = remember {
                mutableStateOf("")
            }
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize().padding(16.dp)
                ) {
                    TextField(value = textField.value, label = {
                        Text("user name")
                    }, onValueChange = {
                        textField.value = it
                    }, modifier = Modifier.fillMaxWidth(), singleLine = true)

                    Spacer(Modifier.height(16.dp))
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd) {
                        Button(onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Hii ${textField.value}")
                            }
                        }) {
                            Text(text = "please click me")
                        }
                    }
                }
            }
        }
    }
}