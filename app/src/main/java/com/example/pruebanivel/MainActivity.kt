package com.example.pruebanivel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebanivel.ui.theme.PruebaNivelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaNivelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    HexadecimalString()

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruebaNivelTheme {


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HexadecimalString() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {

        var hexadecimal by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf(" ") }

        Row(
            Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Level Test",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }


        OutlinedTextField(
            value = hexadecimal,
            onValueChange = { hexadecimal = it },
            label = {
                Text("Hexadecimal")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            singleLine = true,

            )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    var catena = ""

                    if (hexadecimal == null) {
                        catena = "There is a field empty"
                    } else {
                        var temp_Char: CharArray = hexadecimal.toCharArray();
                        var i = 0
                        while (i < temp_Char.size) {
                            var Temp_String =
                                "" + temp_Char.get(i) + "" + temp_Char.get(i + 1)
                            var character = Temp_String.toInt(16).toChar()
                            catena += character
                            i += 2
                        }
                        println("The String of the hexadecimal value is: ");
                        println(catena);

                    }
                    outcome = catena
                },
                modifier = Modifier.padding(10.dp),

                ) {
                Text(text = "Convert")
            }
        }

        Text(
            text = outcome,
            modifier = Modifier.padding(20.dp)
        )


    }
}



