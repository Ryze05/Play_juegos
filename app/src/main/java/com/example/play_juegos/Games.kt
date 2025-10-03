package com.example.play_juegos

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.play_juegos.ui.theme.Play_juegosTheme
import com.example.play_juegos.ui.theme.Preferences

data class CheckInfo(var title:String, var selected:Boolean, var onCheckedChange:(Boolean)->Unit)

@Composable
fun Games() {
    //var estadoCheck by rememberSaveable { mutableStateOf(false)}

    val context = LocalContext.current
    val titles = listOf<String>("Angry birds","Dragon fly", "Hill climbing racing", "Pocket soccer", "Radiant defense", "Ninja jump", "Air control");
    val options = getOptions(titles)

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFb9f4c9))
        .padding(vertical = 10.dp)) {

        Column(modifier = Modifier
            .fillMaxSize()) {
            options.forEach{option ->
                MyCheckBox(option)
            }
        }

        FloatingActionButton(
            onClick = {
                val seleccionados = options.filter { it.selected }.map { it.title }
                val mensaje = if (seleccionados.isNotEmpty()) {
                    "Has seleccionado: ${seleccionados.joinToString(", ")}"
                } else {
                    "No seleccionaste ningún juego"
                }
                Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
            },
            shape = CircleShape,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Añadir")
        }

    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo>  {
    return titles.map {
        var estadoCheck by rememberSaveable { mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = estadoCheck,
            onCheckedChange = { estadoCheck = it },
            //image = it.replace(" ", "_").lowercase()
        )
    }
}

@Composable
fun MyCheckBox(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically ) {
        Image(
            painter = when(checkInfo.title) {
                "Angry birds" ->  painterResource(id = R.drawable.angry_birds)
                "Dragon fly" -> painterResource(id = R.drawable.games_dragonfly)
                "Hill climbing racing" -> painterResource(id = R.drawable.games_hillclimbingracing)
                "Pocket soccer" -> painterResource(id = R.drawable.games_pocketsoccer)
                "Radiant defense" -> painterResource(id = R.drawable.games_radiantdefense)
                "Ninja jump" -> painterResource(id = R.drawable.games_ninjump)
                "Air control" -> painterResource(id = R.drawable.games_aircontrol)
                else -> painterResource(id = R.drawable.angry_birds)
            },
            //painter = painterResource(id = R.drawable.angry_birds),
            contentDescription = "Account",
            modifier = Modifier.requiredSize(60.dp)
        )

        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = {
                checkInfo.onCheckedChange(!checkInfo.selected) })
        //Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Preview(showBackground = true)
@Composable
fun GamesPreview() {
    Play_juegosTheme {
        Games()
    }
}