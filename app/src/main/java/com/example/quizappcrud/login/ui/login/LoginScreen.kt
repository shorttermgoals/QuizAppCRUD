package com.example.quizappcrud.login.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizappcrud.R
import com.example.quizappcrud.login.data.nombre_coleccion
import kotlinx.coroutines.launch
import com.example.quizappcrud.login.data.db
import com.example.quizappcrud.login.ui.login.*

@Composable
fun LoginScreen(LoginViewModel: LoginViewModel, navController: NavHostController) {

    val email:String by LoginViewModel.email.observeAsState(initial = "")
    val password:String by LoginViewModel.password.observeAsState(initial = "")
    val confirmation_message by LoginViewModel.confirmation_message.observeAsState(initial = "")

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
                Text(   text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp))
                //Input de texto
                OutlinedTextField(
                    value = email,
                    onValueChange = { LoginViewModel.onCompletedFields(email = it, password = password) },
                    label = { Text("Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = password,
                    onValueChange = { LoginViewModel.onCompletedFields(email = email, password = it) },
                    label = { Text("Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    singleLine = true,
                )
                val dato = hashMapOf(
                    "email" to email.toString(),
                    "password" to password.toString()
                )

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        LoginViewModel.rutaButton(navController,"RegisterScreen" )
                    }) {
                    Text(text = "Ir al registro")
                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        LoginViewModel.loginButton(db, nombre_coleccion, email, password)
                    }) {
                    Text(text = "Login")
                }

                Text(text = confirmation_message, modifier = Modifier.padding(top = 10.dp))





            }
        }
    }
}


