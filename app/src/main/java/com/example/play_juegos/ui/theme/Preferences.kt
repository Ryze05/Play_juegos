package com.example.play_juegos.ui.theme

import android.preference.Preference
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.play_juegos.New_player

@Composable
fun Preferences() {

    var context = LocalContext.current
    var stateOption by remember { mutableStateOf("No has pulsado ninguna opción") }
    val range = 0.0f..100.0f
    val steps = 11
    var selection by remember { mutableStateOf(50f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFb9f4c9))
            .padding(vertical = 10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Elige una opción:",
            )

            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
                MyRadioButton(stateOption){stateOption = it}
                Slider(
                    value = selection,
                    valueRange = range,
                    onValueChange = { selection = it },
                    steps = steps,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF379665),
                        activeTrackColor = Color(0xFF379665),
                        inactiveTrackColor = Color(0xFF379665)
                    )
                )
            }





        }

        FloatingActionButton(
            onClick = { Toast.makeText(context, "Has seleccionado $stateOption con una puntuación de $selection", Toast.LENGTH_LONG).show() },
            shape = CircleShape,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.BottomEnd)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Añadir")
        }
    }
}

@Composable
fun MyRadioButton(stateOption: String, onItemSelected:(String) -> Unit) {
    var nombres = listOf<String>("Angry birds","Dragon fly", "Hill climbing racing", "Pocket soccer", "Radiant defense", "Ninja jump", "Air control");

    nombres.forEach { name ->
        Row {
            RadioButton(
                selected = stateOption == name,
                onClick = { onItemSelected(name) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red
                )
            )
            Text(
                text = name,
                Modifier.padding(top = 12.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreferencesPreview() {
    Play_juegosTheme {
        Preferences()
    }
}