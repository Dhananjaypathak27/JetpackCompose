package com.inxparticle.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var userName by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = userName, label = {
            Text(text = "User Name")
        }, onValueChange = {
            userName = it
        }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = password, label = {
                                            Text(text = "Password")
        }, onValueChange = {
            password = it
        }, modifier = Modifier.fillMaxWidth())
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd){
            Button(onClick = {
                if(userName.isNotBlank() && password.isNotBlank()){
//             context.startActivity(Intent(context,NavigationDrawer::class.java))

                    val intent = Intent(context, NavigationDrawerActivity::class.java)
//                intent.putExtra(YourExtraKey, YourExtraValue)
                    context.startActivity(intent)
                }

            }) {
                Text(text = "Submit")
            }
        }

    }
}