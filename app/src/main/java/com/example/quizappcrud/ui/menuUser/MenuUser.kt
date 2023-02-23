package com.example.quizappcrud.ui.menuUser

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
fun MenuUser(ViewModelMenuUser:ViewModelMenuUser, navController: NavHostController) {

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
                Text(   text = "Hola *usuario*",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp))

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelMenuUser.rutaButton(navController,"Menu")
                    }) {
                    Text(text = "Menu administrador")
                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelMenuUser.rutaButton(navController,"Inicio")
                    }) {
                    Text(text = "Quiz")
                }



            }
        }
    }
}