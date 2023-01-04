package com.inxparticle.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnList()
        }
    }


    @Composable
    fun ColumnScroll(){
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)){
            for(i in 1..90){
                Text(text = "Item $i",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }


    @Preview
    @Composable
    fun LazyColumnList(){
        LazyColumn{
            //type of for each loop
            itemsIndexed(
                listOf("this","is","jetPack","compose","is","jetPack","compose","is","jetPack","compose","is","jetPack","compose","is","jetPack","compose","is","jetPack","compose","is","jetPack","compose","is","jetPack","compose","is","jetPack","compose")
            ){index, item ->
                Text(text = " $item",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }


//            //type of for loop
//            items(400) {
//                Text(text = "Item $it",
//                    fontSize = 35.sp,
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.fillMaxWidth()
//                )
//            }
        }
    }
}