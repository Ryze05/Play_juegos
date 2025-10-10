package com.example.play_juegos

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.play_juegos.ui.theme.Play_juegosTheme

data class User(
    var name:String,
    var puntos: String,
    @DrawableRes var photo: Int
)
/*@Composable
fun About() {
    val users = listOf(
        Users("María Mata", "2014"),
        Users("Antonio Sanz", "2056"),
        Users("Carlos Pérez", "5200"),
        Users("Beatriz Martos", "1892"),
        Users("Sandra Alegre", "3400"),
        Users("Alex Serrat", "5874")
    )
    /*Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)) {

        Column(modifier = Modifier
            .fillMaxWidth()) {

        }
    }*/
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            //Text(text = "Ranking de Usuarios", color = Color.White)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(users) { user ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.account),
                            contentDescription = "Account",
                            modifier = Modifier.requiredSize(80.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            Text(text = user.name, color = Color.Black)
                            Text(text = "Puntos: ${user.puntos}", color = Color.Black)
                        }
                    }
                }
            }

        }
    }
}*/

@Composable
fun LazyColumn(modifier : Modifier = Modifier, navController: NavController)  {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.padding(10.dp).fillMaxWidth()){
            items(getSuperHeroes()) { superHero ->
                ItemHero(superhero = superHero)
            }
        }

    }
}

@Composable
fun ItemHero(user: User) {
    Row() {
        Image(
            painter = painterResource(id = user.photo),
            contentDescription = "Dragon Ball",
            modifier = Modifier.requiredSize(80.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = user.name)
            Text(text = user.puntos)
            //Text(text = user.publisher)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AboutPreview() {
    Play_juegosTheme {
        About()
    }
}