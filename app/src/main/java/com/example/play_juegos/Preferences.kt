package com.example.play_juegos

import android.R
import android.R.attr.color
import android.preference.Preference
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SmallFloatingActionButton
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
import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun Preferences() {

    var context = LocalContext.current
    var stateOption by remember { mutableStateOf("No has pulsado ninguna opción") }
    val range = 0.0f..100.0f
    val steps = 11
    var selection by remember { mutableStateOf(50f) }
    var starsSelected by remember { mutableStateOf(0.0) }
    var selectedChip by remember { mutableStateOf("No has seleccionado la plataforma") }

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
                        inactiveTrackColor = Color(0xFFACFBBE)
                    )
                )
                RatingBar(rating = starsSelected, stars = 10, onItemSelected = { newValue -> starsSelected = newValue })

                Text("Plataformas:")

                MyFilterChip(selectedChip) {selectedChip = it}
            }





        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd // coloca ambos botones en la esquina inferior derecha
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp), // espacio entre los botones
                horizontalAlignment = Alignment.End
            ) {
                SmallFloatingActionButton(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Has seleccionado $stateOption con estas estrellas $starsSelected",
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    shape = CircleShape,
                    containerColor = Color(0xFFabeabe)
                ) {
                    Icon(Icons.Default.Star, contentDescription = "Añadir")
                }

                FloatingActionButton(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Has seleccionado $stateOption con una puntuación de $selection",
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    shape = CircleShape,
                    containerColor = Color(0xFFF9AA33)
                ) {
                    Icon(Icons.Default.Done, contentDescription = "Añadir", tint = Color.White)
                }
            }
        }

    }
}


@Composable
fun MyFilterChip(selectedChip: String, onItemSelected: (String) -> Unit) {
    val nombres = listOf("PS4", "XBOX", "3DS", "WII", "WIIU")
    val context = LocalContext.current

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        nombres.forEach { name ->
            FilterChip(
                selected = selectedChip == name,
                onClick = {
                    onItemSelected(name)
                    Toast.makeText(context, "Has seleccionado $name", Toast.LENGTH_LONG).show()
                },
                label = { Text(text = name) },
                leadingIcon = if (selectedChip == name) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else null
            )
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

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color(0xFF888888),
    onItemSelected: (Double) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        for (i in 1..stars) {
            val icon = if (i <= floor(rating).toInt()) {
                Icons.Filled.Star
            } else {
                Icons.Outlined.Star
            }
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (i <= rating) Color(0xFF379665) else starsColor,
                modifier = Modifier
                    .clickable { onItemSelected(i.toDouble()) }
                    .padding(2.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreferencesPreview() {
    _root_ide_package_.com.example.play_juegos.ui.theme.Play_juegosTheme {
        Preferences()
    }
}