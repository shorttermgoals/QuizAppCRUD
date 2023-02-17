package com.example.quizappcrud.crud.modificar

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
fun ModificarDatos(ViewModelModificar: ViewModelModificar) {

    val db = db
    var nombre_coleccion = nombre_coleccion

    val idBusqueda:String by ViewModelModificar.idBusqueda.observeAsState (initial = "")
    val id:String by ViewModelModificar.id.observeAsState (initial = "")
    val pregunta:String by ViewModelModificar.pregunta.observeAsState (initial = "")
    val respuesta1:String by ViewModelModificar.respuesta1.observeAsState (initial = "")
    val respuesta2:String by ViewModelModificar.respuesta2.observeAsState (initial = "")
    val respuesta3:String by ViewModelModificar.respuesta3.observeAsState (initial = "")
    val respuestaCorrecta:String by ViewModelModificar.respuestaCorrecta.observeAsState (initial = "")
    val isButtonEnable:Boolean by ViewModelModificar.isButtonEnable.observeAsState (initial = false)
    val confirmation_message:String by ViewModelModificar.confirmation_message.observeAsState(initial = "")

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
                Text(   text = "Editar datos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp))
                //Input de texto
                OutlinedTextField(
                    value = idBusqueda,
                    onValueChange = { ViewModelModificar.onCompletedFields(idBusqueda = idBusqueda, id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta) },
                    label = { Text("ID del dato a editar") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = id,
                    onValueChange = { ViewModelModificar.onCompletedFields(idBusqueda = idBusqueda, id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta) },
                    label = { Text("ID") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = pregunta,
                    onValueChange = { ViewModelModificar.onCompletedFields(idBusqueda = idBusqueda, id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta)  },
                    label = { Text("Pregunta") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = respuesta1,
                    onValueChange = { ViewModelModificar.onCompletedFields(idBusqueda = idBusqueda, id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta)  },
                    label = { Text("Respuesta 1") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = respuesta2,
                    onValueChange = { ViewModelModificar.onCompletedFields(idBusqueda = idBusqueda, id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta)  },
                    label = { Text("Respuesta 2") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = respuesta3,
                    onValueChange = { ViewModelModificar.onCompletedFields(idBusqueda = idBusqueda, id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta)  },
                    label = { Text("Respuesta 3") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                //Input de texto
                OutlinedTextField(
                    value = respuestaCorrecta,
                    onValueChange = { ViewModelModificar.onCompletedFields(idBusqueda = idBusqueda, id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta)  },
                    label = { Text("Respuesta Correcta") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    singleLine = true,
                )
                ViewModelModificar.onCompletedFields(idBusqueda = idBusqueda, id = id, pregunta = pregunta, respuesta1 = respuesta1, respuesta2 = respuesta2, respuesta3 = respuesta3, respuestaCorrecta = respuestaCorrecta)
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
                        ViewModelModificar.modificarButton(db,nombre_coleccion, idBusqueda, dato)
                    }) {
                    Text(text = "Editar")
                }

                Text(text = confirmation_message, modifier = Modifier.padding(top = 10.dp))





            }
        }
    }
}