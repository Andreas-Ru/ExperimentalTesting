package com.example.experimentaltesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.experimentaltesting.ui.theme.ExperimentalTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExperimentalTestingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(Modifier
                        .fillMaxSize()
                        .padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier) {

    Surface {
        Column(
            modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(R.drawable.samoyed),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
                    .padding(bottom = 24.dp)
            )

            Text(
                "Rasse: Samojede"
            )

            Text(
                "Ursprung: Russland"
            )

            Text(
                "Gewicht: 17-25kg"
            )

            Button(
                onClick = {},
                Modifier.padding(top = 48.dp)
            ) {
                Text("jetzt adoptieren")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    ExperimentalTestingTheme {
        HomeScreen(Modifier)
    }
}