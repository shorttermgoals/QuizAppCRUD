package com.example.quizappcrud.login.ui.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizappcrud.login.data.db
import com.example.quizappcrud.login.data.nombre_coleccion

@Composable
fun RegisterScreen(RegisterViewModel: RegisterViewModel, navController: NavHostController) {

    val db = db
    val nombre_collecion = nombre_coleccion

    val nombre:String by RegisterViewModel.nombre.observeAsState(initial = "")
    val apellidos:String by RegisterViewModel.apellidos.observeAsState(initial = "")
    val edad:String by RegisterViewModel.edad.observeAsState(initial = "")
    val nacionalidad:String by RegisterViewModel.nacionalidad.observeAsState(initial = "")
    val email:String by RegisterViewModel.email.observeAsState(initial = "")
    val password:String by RegisterViewModel.password.observeAsState(initial = "")
    val confirmation_message by RegisterViewModel.confirmation_message.observeAsState(initial = "")

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
                Text(   text = "Introduzca los datos de registro",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp))
                //Input de texto
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { RegisterViewModel.onCompletedFields( nombre = it, apellidos = apellidos, edad = edad, nacionalidad = nacionalidad, email = email, password = password) },
                    label = { Text("Nombre") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = apellidos,
                    onValueChange = { RegisterViewModel.onCompletedFields( nombre = nombre, apellidos = it, edad = edad, nacionalidad = nacionalidad, email = email, password = password) },
                    label = { Text("Apellidos") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = edad,
                    onValueChange = { RegisterViewModel.onCompletedFields( nombre = nombre, apellidos = apellidos, edad = it, nacionalidad = nacionalidad, email = email, password = password) },
                    label = { Text("Edad") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = nacionalidad,
                    onValueChange = { RegisterViewModel.onCompletedFields( nombre = nombre, apellidos = apellidos, edad = edad, nacionalidad = it, email = email, password = password) },
                    label = { Text("Nacionalidad") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = email,
                    onValueChange = { RegisterViewModel.onCompletedFields( nombre = nombre, apellidos = apellidos, edad = edad, nacionalidad = nacionalidad, email = it, password = password) },
                    label = { Text("Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = password,
                    onValueChange = { RegisterViewModel.onCompletedFields( nombre = nombre, apellidos = apellidos, edad = edad, nacionalidad = nacionalidad, email = email, password = it) },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                val dato = hashMapOf(
                    "nombre" to nombre.toString(),
                    "apellidos" to apellidos.toString(),
                    "edad" to edad.toString(),
                    "nacionalidad" to nacionalidad.toString(),
                    "email" to email.toString(),
                    "password" to password.toString()
                )

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        RegisterViewModel.rutaButton(navController,"LoginScreen")
                    }) {
                    Text(text = "Ir al inicio de sesión")
                }


                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        RegisterViewModel.registerButton(db, nombre_coleccion, email, dato)
                    }) {
                    Text(text = "Guardar")
                }

                Text(text = confirmation_message, modifier = Modifier.padding(top = 10.dp))

            }
        }
    }
}