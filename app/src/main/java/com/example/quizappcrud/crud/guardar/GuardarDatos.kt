package com.example.quizappcrud.crud.guardar

import android.graphics.Color.*
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
import com.example.quizappcrud.crud.db
import com.example.quizappcrud.crud.nombre_coleccion


@Composable
fun GuardarDatos(ViewModelGuardar: ViewModelGuardar){
    val db = db
    val nombre_collecion = nombre_coleccion

    val id:String by ViewModelGuardar.id.observeAsState(initial = "")
    val pregunta:String by ViewModelGuardar.pregunta.observeAsState (initial = "")
    val respuesta1:String by ViewModelGuardar.respuesta1.observeAsState (initial = "")
    val respuesta2:String by ViewModelGuardar.respuesta2.observeAsState (initial = "")
    val respuesta3:String by ViewModelGuardar.respuesta3.observeAsState (initial = "")
    val respuestaCorrecta:String by ViewModelGuardar.respuestaCorrecta.observeAsState (initial = "")
    val isButtonEnable:Boolean by ViewModelGuardar.isButtonEnable.observeAsState (initial = false)
    val confirmation_message:String by ViewModelGuardar.confirmation_message.observeAsState(initial = "")

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
                Text(   text = "Guardar datos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp))
                //Input de texto
                OutlinedTextField(
                    value = id,
                    onValueChange = { ViewModelGuardar.onCompletedFields(id = it, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta) },
                    label = { Text("Número pregunta") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = pregunta,
                    onValueChange = { ViewModelGuardar.onCompletedFields(id = id, pregunta = it, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta) },
                    label = { Text("Pregunta") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = respuesta1,
                    onValueChange = { ViewModelGuardar.onCompletedFields(id = id, pregunta = pregunta, respuesta1 = it, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta) },
                    label = { Text("Respuesta 1") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = respuesta2,
                    onValueChange = { ViewModelGuardar.onCompletedFields(id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = it, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta) },
                    label = { Text("Respuesta 2") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = respuesta3,
                    onValueChange = { ViewModelGuardar.onCompletedFields(id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = it, respuestaCorrecta = respuestaCorrecta) },
                    label = { Text("Respuesta 3") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = respuestaCorrecta,
                    onValueChange = { ViewModelGuardar.onCompletedFields(id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = it) },
                    label = { Text("Respuesta Correcta (Debe coincidir con una de las respuestas introducidas)") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                val dato = hashMapOf(
                    "id" to id.toString(),
                    "pregunta" to pregunta.toString(),
                    "respuesta1" to respuesta1.toString(),
                    "respuesta2" to respuesta2.toString(),
                    "respuesta3" to respuesta3.toString(),
                    "respuestaCorrecta" to respuestaCorrecta.toString()
                )


                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelGuardar.guardarButton(db, nombre_coleccion, id, dato, respuesta1, respuesta2, respuesta3, respuestaCorrecta)
                    }) {
                    Text(text = "Guardar")
                }

                Text(text = confirmation_message, modifier = Modifier.padding(top = 10.dp))





            }
        }
    }
}