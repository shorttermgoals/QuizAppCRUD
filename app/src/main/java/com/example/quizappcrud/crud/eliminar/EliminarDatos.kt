package com.example.quizappcrud.crud.eliminar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizappcrud.crud.db
import com.example.quizappcrud.crud.nombre_coleccion

@Composable
fun EliminarDatos(ViewModelEliminar: ViewModelEliminar, navController: NavHostController) {
    val db = db
    var nombre_coleccion = nombre_coleccion

    val id:String by ViewModelEliminar.id.observeAsState(initial = "")
    val confirmation_message:String by ViewModelEliminar.confirmation_message.observeAsState("")
    val isButtonEnable:Boolean by ViewModelEliminar.isButtonEnable.observeAsState (initial = false)


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
                Text(   text = "Eliminar datos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp))
                //Input de texto
                OutlinedTextField(
                    value = id,
                    onValueChange = { ViewModelEliminar.onCompletedFields(id = it) },
                    label = { Text("Introduzca la ID del dato que desea eliminar") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelEliminar.rutaButton(navController,"Menu" )
                    }) {
                    Text(text = "Ir a menú")
                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelEliminar.eliminarButton(db,nombre_coleccion, id)
                    }) {
                    Text(text = "Eliminar")
                }

                Text(text = confirmation_message, modifier = Modifier.padding(top = 10.dp))

            }
        }
    }
}