package com.example.score

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                MessageCard()
            }
        }
    }
}

@Composable
fun MessageCard(){
    var scoreValue by remember {mutableIntStateOf(0)}

    Column(
        modifier = Modifier.padding(all = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Score :",
            fontSize = 50.sp,
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "$scoreValue",
            fontSize = 50.sp,
            modifier = Modifier.border(2.dp, MaterialTheme.colorScheme.primary).padding(50.dp)
        )

        Row(
            modifier = Modifier.padding(all = 4.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Surface(
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.animateContentSize().padding(5.dp)
            ) {
            Text("+1",
                modifier = Modifier.clickable{scoreValue += 1}.padding(10.dp),
                fontSize = 25.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.animateContentSize().padding(5.dp)
            ){
                Text("-1",
                    modifier = Modifier.clickable{scoreValue -= 1}.padding(10.dp),
                    fontSize = 25.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard()
}