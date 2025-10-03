package com.example.play_juegos

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.play_juegos.ui.theme.Play_juegosTheme
import com.example.play_juegos.ui.theme.Preferences

val courgetteFontFamily = FontFamily(
    Font(R.font.courgette_regular, FontWeight.Normal)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Play_juegosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "Portada",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("Portada") { Portada(navController = navController) }
                        composable("New player") { New_player() }
                        composable ("Preferences") { Preferences() }
                        composable ("Play") { Games() }
                    }
                }
            }
        }

    }
}

@Composable
fun Portada(modifier: Modifier = Modifier, navController: NavController) {

    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Orientacion_Panorama(navController = navController)
        }
        else -> {
            Orientacion_Retrato(navController = navController)
        }
    }
}

@Composable
fun Orientacion_Panorama(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = modifier,
            fontFamily = courgetteFontFamily,
            fontSize = 70.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.size(40.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(onClick = { navController.navigate("Play") },modifier.width(150.dp) ,colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)) {
                    Text(
                        text = stringResource(id = R.string.play),
                        modifier = modifier,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                //Spacer(modifier = Modifier.size(10.dp))

                Button(onClick = { navController.navigate("New player") }, modifier.width(150.dp),colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4BA660))) {
                    Text(
                        text = stringResource(id = R.string.new_player),
                        modifier = modifier,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }


            Spacer(modifier = Modifier.size(10.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(onClick = {}, modifier.width(150.dp),colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4BA660))) {
                    Text(
                        text = stringResource(id = R.string.preferences),
                        modifier = modifier,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                //Spacer(modifier = Modifier.size(10.dp))

                Button(onClick = {}, modifier.width(150.dp),colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4BA660))) {
                    Text(
                        text = stringResource(id = R.string.about),
                        modifier = modifier,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

        }
    }
}

@Composable
fun Orientacion_Retrato(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = modifier,
            fontFamily = courgetteFontFamily,
            fontSize = 70.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.size(40.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(240.dp)) {
            Button(onClick = {navController.navigate("Play")}, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)) {
                Text(
                    text = stringResource(id = R.string.play),
                    modifier = modifier,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = {navController.navigate("New player")}, modifier = Modifier.fillMaxWidth() ,colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4BA660))) {
                Text(
                    text = stringResource(id = R.string.new_player),
                    modifier = modifier,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = {navController.navigate("Preferences")}, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4BA660))) {
                Text(
                    text = stringResource(id = R.string.preferences),
                    modifier = modifier,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = {}, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4BA660))) {
                Text(
                    text = stringResource(id = R.string.about),
                    modifier = modifier,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun PortadaPreview() {
    Play_juegosTheme {
        Portada()
    }
}*/