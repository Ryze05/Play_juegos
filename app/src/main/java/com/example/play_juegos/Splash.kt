package com.example.play_juegos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.play_juegos.ui.theme.Play_juegosTheme
import kotlinx.coroutines.delay

@Composable
/*fun Splash() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFb9f4c9))
        .padding(vertical = 10.dp))
    {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.account),
                contentDescription = "Account",
                modifier = Modifier.requiredSize(80.dp)
            )

            Text("Created by")
            Text("Rommel Romero")
        }
    }
}*/

fun Splash(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFb9f4c9))
            .padding(vertical = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Account",
            modifier = Modifier
                .requiredSize(80.dp)
                .align(Alignment.Center)
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Created by")
            Text("Rommel Romero")
        }
    }

    LaunchedEffect(true) {
        delay(2000)
        navController.navigate("Portada")
    }
}


/*@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    Play_juegosTheme {
        Splash(navController)
    }
}*/