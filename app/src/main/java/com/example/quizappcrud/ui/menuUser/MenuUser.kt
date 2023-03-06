package com.example.quizappcrud.ui.menuUser

import LoginViewModel
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.quizappcrud.ui.menuUser.ViewModelMenuUser
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizappcrud.login.ui.register.RegisterViewModel
import com.example.quizappcrud.R


@Composable
fun MenuUser(ViewModelMenuUser:ViewModelMenuUser, navController: NavHostController, LoginViewModel: LoginViewModel, RegisterViewModel: RegisterViewModel) {
    val emailUsuario = LoginViewModel.email.value
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
                Image(painter = painterResource(R.drawable.logoquizapp_720) , contentDescription = "Logo",
                modifier = Modifier.padding(bottom = 15.dp))
                Text(   text = "Hola",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp))

                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                        onClick = {
                            println("Hola")

                            if(emailUsuario == "dperezm8@alumnos.nebrija.es" || emailUsuario == "hgilg@alumnos.nebrija.es") {
                                ViewModelMenuUser.rutaButton(navController, "Menu")
                            }else {
                                ViewModelMenuUser.rutaButton(navController, "LoginScreen")
                            }
                        }) {
                        Text(text = "Volver")
                    }


                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelMenuUser.rutaButton(navController,"AppScreens")
                    }) {
                    Text(text = "Quiz")
                }



            }
        }
    }
}