package com.example.play_juegos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.play_juegos.ui.theme.Play_juegosTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


@Composable
fun New_player() {

    var name by remember { mutableStateOf(" ") }
    var surname by remember { mutableStateOf(" ") }
    var nickname by remember { mutableStateOf(" ") }
    var number by remember { mutableStateOf(" ") }
    var email by remember { mutableStateOf(" ") }
    var nameError by remember { mutableStateOf(false) }
    var nicknameError by remember { mutableStateOf(false) }

    var expanded by remember { mutableStateOf(false) }

    val emails =
        listOf("example1@gmail.com", "example2@gmail.com", "example3@gmail.com", "example4@gmail.com", "example5@gmail.com")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 16.dp, vertical = 18.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            Image(
                painter = painterResource(id = R.drawable.account),
                contentDescription = "Account",
                modifier = Modifier.requiredSize(80.dp)
            )

            Spacer(modifier = Modifier.size(20.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text("Nombre") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF8dd5a8)),
                    label = { Text("Nombre") }
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = if (nameError) "Error: Es obligatorio" else "* Obligatorio",
                        color = if (nameError) MaterialTheme.colorScheme.error else Color(0xFF41624d),
                        textAlign = TextAlign.Right
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))

                OutlinedTextField(
                    value = surname,
                    onValueChange = { surname = it },
                    placeholder = { Text("Apellidos") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF8dd5a8)),
                    label = { Text("Apellidos") }
                )

                Spacer(modifier = Modifier.size(20.dp))

                OutlinedTextField(
                    value = nickname,
                    onValueChange = { nickname = it },
                    placeholder = { Text("Nickname") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF8dd5a8)),
                    label = { Text("Nickname") }
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = if (nicknameError) "Error: Es obligatorio" else "* Obligatorio",
                        color = if (nicknameError) MaterialTheme.colorScheme.error else Color(0xFF41624d)
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.android),
                        contentDescription = "Android image",
                        modifier = Modifier.requiredSize(80.dp)
                    )

                    Spacer(modifier = Modifier.size(20.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier.width(150.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFf9aa33)),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.change),
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.camera),
                contentDescription = "Camera image",
                modifier = Modifier.requiredSize(80.dp)
            )

            Spacer(modifier = Modifier.size(20.dp))

            OutlinedTextField(
                value = number,
                onValueChange = { number = it },
                placeholder = { Text("Teléfono") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF8dd5a8)),
                label = { Text("Teléfono") }
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.email),
                    contentDescription = "Email image",
                    modifier = Modifier.requiredSize(80.dp)
                )

                Spacer(modifier = Modifier.size(20.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { },
                    placeholder = { Text("Email") },
                    singleLine = true,
                    readOnly = true,
                    enabled = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF8dd5a8))
                        .clickable { expanded = true },
                    label = { Text("Email") }
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                emails.forEach { email2 ->
                    DropdownMenuItem(
                        onClick = {
                            email = email2
                            expanded = false
                        },
                        text = { Text(email2) }
                    )
                }
            }
        }


        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = {
                nameError = name.isBlank()
                nicknameError = nickname.isBlank()
            },
            modifier = Modifier.width(150.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF379665)),
            shape = RoundedCornerShape(15.dp)

        ) {
            Text(
                text = stringResource(id = R.string.add_new),
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PortadaPreview() {
    Play_juegosTheme {
        New_player()
    }
}