package com.example.play_juegos.ui.theme

import android.preference.Preference
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        }

        FloatingActionButton(
            onClick = { Toast.makeText(context, "mensaje ", Toast.LENGTH_LONG).show() },
            shape = CircleShape,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.BottomEnd)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Añadir")
        }
    }
}




/*fun Preferences() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFb9f4c9))
    ) {
        Column() {
            Text(
                "Elige una opción",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}*/


@Preview(showBackground = true)
@Composable
fun PreferencesPreview() {
    Play_juegosTheme {
        Preferences()
    }
}