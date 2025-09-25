package com.example.lab1_part2

import android.os.Bundle
import android.util.MutableBoolean
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.lab1_part2.ui.theme.Lab1_part2Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1_part2Theme {
                 var s by remember{ mutableStateOf(false)}
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {Bottom(onToggle = {s=!s})}, topBar = { Top() }){
                    innerPadding -> Content(modifier = Modifier.padding(innerPadding),show = s)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Top(modifier: Modifier = Modifier)
{
   TopAppBar(title ={Column (modifier = modifier.fillMaxSize().background(Color.Yellow), verticalArrangement = Arrangement.Center){Text(text= "Apple pie recipe", fontSize = 30.sp)}}, modifier = modifier.height(100.dp))
}
@Composable
fun Bottom(modifier: Modifier = Modifier, onToggle: ()-> Unit)
{
    BottomAppBar (modifier = modifier.height(100.dp).background(Color.Yellow))
    {
        Column(modifier= modifier.fillMaxSize().background(Color.Yellow), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Button(onClick = onToggle){Text("Toggle")}
        }
    }
}  @Composable fun Content(modifier: Modifier = Modifier, show: Boolean) { Column(modifier = modifier.fillMaxSize().background(Color.Green), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Make an apple pie", fontSize = 30.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, color = Color.Gray)
        if (show) Text(text = "Peel and slice 6 apples, then toss them with sugar, cinnamon, and a little flour. edges, and cut slits for steam. ", fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
        Image(painter = painterResource(R.drawable.apples), modifier = Modifier.size(size = 200.dp) ,contentDescription = null)
        if (show) Text(text = "Place the mixture into a pie crust, top with another crust (or lattice), seal edges, and cut slits for steam. Bake at 375°F (190°C) for 50–60 minutes until golden brown and bubbly.", fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
        Image(painter = painterResource(R.drawable.pie), modifier = Modifier.size(size = 200.dp) ,contentDescription = null)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab1_part2Theme {
       Content(show = false)
    }
}