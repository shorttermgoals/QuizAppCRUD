package com.example.quizappcrud.crud.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Menu(ViewModelMenu: ViewModelMenu, navController: NavHostController) {

    Card(
    modifier = Modifier
    .fillMaxWidth()
    .padding(16.dp),
    elevation = 12.dp,
    shape = MaterialTheme.shapes.small,
    backgroundColor = Color.White,
    contentColor = Color.DarkGray,
    border = BorderStroke(1.dp, Color.DarkGray)
    ) {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column( modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(   text = "Gestión de datos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp))

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelMenu.rutaButton(navController,"GuardarDatos")
                    }) {
                    Text(text = "Guardar")
                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelMenu.rutaButton(navController,"ModificarDatos")
                    }) {
                    Text(text = "Editar")
                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelMenu.rutaButton(navController,"EliminarDatos")
                    }) {
                    Text(text = "Eliminar")
                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelMenu.rutaButton(navController,"InformeDatos")
                    }) {
                    Text(text = "Informe datos")
                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelMenu.rutaButton(navController,"MenuUser")
                    }) {
                    Text(text = "Menu usuario")
                }

            }
        }
    }
}