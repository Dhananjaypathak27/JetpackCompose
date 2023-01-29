package com.inxparticle.jetpackcompose.phillipUI

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inxparticle.jetpackcompose.ui.theme.*

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            GreetingSection()
            ChipSection()
            ThoughtSection()
            FeatureSection()
        }
        BottomBar(modifier = Modifier.align(Alignment.BottomCenter))

    }
}

@Composable
fun GreetingSection(name: String = "Dhananjay") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Text(text = "Good Morning, $name", fontSize = 22.sp, color = Color.White)
            Text(text = "We wish you have a good day!", fontSize = 18.sp, color = AquaBlue)
        }
        Icon(
            painter = painterResource(id = com.inxparticle.jetpackcompose.R.drawable.ic_search),
            contentDescription = "Search",
            Modifier.size(24.dp),
            tint = Color.White
        )
    }
}

@Composable
fun ChipSection() {
    val selectedItem = remember {
        mutableStateOf(0)
    }

    val list = listOf(
        ChipItemModel(0, "Sweet Sleep"),
        ChipItemModel(1, "Insomania"),
        ChipItemModel(2, "Depression")
    )

    LazyRow {
        items(list.size) {
            Box(modifier = Modifier
                .padding(end = 15.dp)
                .clickable {
                    selectedItem.value = it
                }
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (it == selectedItem.value)
                        ButtonBlue
                    else
                        DarkerButtonBlue
                )
            ) {
                Text(
                    text = list[it].name, fontSize = 16.sp, color = Color.White,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 15.dp)
                )
            }
        }
    }
}

@Composable
fun ThoughtSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightRed)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "Daily Thought", color = Color.White, fontSize = 22.sp)
                Text(text = "Mediation 3-10 min", color = Color.White, fontSize = 16.sp)
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(ButtonBlue)
            ) {
                Icon(
                    modifier = Modifier
                        .padding(14.dp)
                        .size(20.dp),
                    painter = painterResource(id = com.inxparticle.jetpackcompose.R.drawable.ic_play),
                    contentDescription = "profile",
                    tint = Color.White
                )
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection() {
    val list = listOf(
        FeatureModel(
            "Sleep Meditiation",
            com.inxparticle.jetpackcompose.R.drawable.ic_headphone,
            LightGreen3
        ),
        FeatureModel(
            "Tips for sleep",
            com.inxparticle.jetpackcompose.R.drawable.ic_music,
            AquaBlue
        ),
        FeatureModel(
            "Sleep power nap",
            com.inxparticle.jetpackcompose.R.drawable.ic_profile,
            OrangeYellow3
        ),
        FeatureModel(
            "Supernam Sleep",
            com.inxparticle.jetpackcompose.R.drawable.ic_moon,
            BlueViolet3
        )
    )

    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(count = list.size) {
            FeatureItem(item = list[it])
        }
    }
}

@Composable
fun FeatureItem(item: FeatureModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(5.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
                .background(item.color)
                .padding(10.dp), verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = item.name, fontSize = 22.sp, color = Color.White)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = item.drawableId),
                    contentDescription = item.name,
                    tint = Color.White
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonBlue)
                        .padding(vertical = 10.dp, horizontal = 8.dp)
                ) {
                    Text(text = "Start", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun BottomBar(modifier: Modifier) {
    val currentItemSelected = remember {
        mutableStateOf(0)
    }

    val list = listOf(
        BottomBarItemModel("Home", com.inxparticle.jetpackcompose.R.drawable.ic_home),
        BottomBarItemModel("Mediate", com.inxparticle.jetpackcompose.R.drawable.ic_bubble),
        BottomBarItemModel("Sleep", com.inxparticle.jetpackcompose.R.drawable.ic_moon),
        BottomBarItemModel("Music", com.inxparticle.jetpackcompose.R.drawable.ic_music),
        BottomBarItemModel("Profile", com.inxparticle.jetpackcompose.R.drawable.ic_profile),
    )

    Box(
        modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(vertical = 10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            list.forEachIndexed { index, item ->
                BottomBarItem(item = item,
                    isSelected = index == currentItemSelected.value) {
                    currentItemSelected.value=index
                }
            }
        }
    }
}

@Composable
fun BottomBarItem(item: BottomBarItemModel,
                  isSelected: Boolean = false,
                  onItemClick: () -> Unit) {

    Column(
        modifier = Modifier.clickable {
            onItemClick()
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if(isSelected)ButtonBlue else DeepBlue)
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = item.drawableId),
                contentDescription = item.name,
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = item.name, color = Color.White)

    }
}