package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.Lab1Theme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


data class Fact(val img: Int , val text: String)

@Composable
fun Content(modifier: Modifier = Modifier) {
    val hello = listOf(
        Fact(img = R.drawable.study_sb, text = "I am studying!"),
        Fact(img = R.drawable.clean_sb, text = "I am cleaning!"),
        Fact(img = R.drawable.coworkers_sb, text = "I am working with my coworkers!"),
        Fact(img = R.drawable.gym_sb, text = "I am going to the gym!"),
        Fact(img = R.drawable.driving_sb, text = "I am driving!"),
        Fact(img = R.drawable.ice_cream_sb, text = "I am eating ice cream!"),
        Fact(img = R.drawable.preparing_sb, text = "I am doing my morning routine!"),
        Fact(img = R.drawable.weekend_sb, text = "I am enjoying the weekend!"),
        Fact(img = R.drawable.karaoke_sb, text = "I am singing karaoke!"),
        Fact(img = R.drawable.walk_the_dog_sb, text = "I am walking the dog!")
    )
    var current by remember { mutableStateOf(hello.random()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Day in the life Spongebob",fontSize = 24.sp, textDecoration = TextDecoration.Underline, modifier = Modifier.padding(top = 32.dp).weight(1f))
        Column (modifier = Modifier.weight(9f), verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = painterResource(current.img),modifier = Modifier.size(300.dp), contentDescription = null)
            Text(text = current.text)
            Button(onClick = {current = hello.random()}){
                Text("Click here")
            }}
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab1Theme {
        Content()
    }
}