package com.example.experimentaltesting

import android.os.Bundle
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
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
                    HomeScreen(
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier) {

    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var telephoneNumber by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var adopted by remember { mutableStateOf(false)}

    val buttonEnabled by remember {
        derivedStateOf {
            name.isNotBlank() && address.isNotBlank() && telephoneNumber.isNotBlank() && checked
        }
    }

    Column(
        modifier = modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painterResource(R.drawable.samoyed),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
        )

        OutlinedTextField(
            label = { Text(text = "Name") },
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.padding(top = 24.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        OutlinedTextField(
            label = { Text(text = "Address") },
            value = address,
            onValueChange = { address = it },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        OutlinedTextField(
            label = { Text(text = "Telephone Number") },
            value = telephoneNumber,
            onValueChange = { telephoneNumber = it },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 48.dp, vertical = 16.dp)) {
            Text("Are you rich?")
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = checked, onCheckedChange = {
                checked = it
            })
        }

        Spacer(modifier = Modifier.weight(1f))

        AnimatedVisibility(adopted) {
            Text("Adopted!")
        }
        AnimatedVisibility(!adopted) {
            Button(
                onClick = { adopted = true},
                Modifier.padding(top = 48.dp),
                enabled = buttonEnabled
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