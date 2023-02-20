package com.example.quizappcrud.ui.test

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quizappcrud.crud.ViewModelConsultar
import com.example.quizappcrud.crud.db
import com.example.quizappcrud.crud.nombre_coleccion

// *TEMPORAL* Antigua extracción de datos desde arrays
// val pr = PreguntaRespuesta.pregunta;
// val re = PreguntaRespuesta.respuestas;
// val rc = PreguntaRespuesta.respuestaCorrecta;

@Composable
fun Test(ViewModelTest:ViewModelTest) {
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Column( modifier = Modifier
            .fillMaxWidth()

            .background(Color.White)
            .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Botones(ViewModelConsultar())

        }
    }
}

@Composable
fun Botones(ViewModelConsultar:ViewModelConsultar){
    var contador  by remember { mutableStateOf(0) }
    var puntuacion by remember { mutableStateOf(0) };
    var enabled by remember{ mutableStateOf(true) };

    val colour = Color.Transparent
    val verde = Color.Green
    val rojo = Color.Red

    var color by remember{ mutableStateOf(colour) }
    var color1 by remember{ mutableStateOf(colour) }
    var color2 by remember{ mutableStateOf(colour) }


    val cont = contador + 1
    Text(
        text = "Pregunta $cont",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 10.dp)
            .fillMaxWidth()
    )
    Text(   text = ViewModelConsultar.consultarButton(db, nombre_coleccion,contador.toString()),
        modifier = Modifier.padding(bottom = 10.dp)
            .fillMaxWidth())

    Button(modifier = Modifier
        .border(10.dp, color)
        .fillMaxWidth()
        .padding(top = 15.dp),
        enabled = enabled,
        onClick = {
            enabled = !enabled
            if(re[contador][0] == rc[contador]) {
                puntuacion += 1

                color = when (color) {
                    colour -> verde
                    else -> colour
                }
            }else {
                color = when (color) {
                    colour -> rojo
                    else -> colour
                }
            }
        }) {
        Text(text = re[contador][0])
    }

    Button(modifier = Modifier
        .border(10.dp, color1)
        .fillMaxWidth()
        .padding(top = 15.dp),
        enabled = enabled,
        onClick = {
            enabled = !enabled
            if(re[contador][1] == rc[contador]) {
                puntuacion += 1

                color1 = when (color1) {
                    colour -> verde
                    else -> colour
                }
            }else {
                color1 = when (color1) {
                    colour -> rojo
                    else -> colour
                }
            }
        }) {
        Text(text = re[contador][1])
    }

    Button(modifier = Modifier
        .border(10.dp, color2)
        .fillMaxWidth()
        .padding(top = 15.dp),
        enabled = enabled,
        onClick = {
            enabled = !enabled
            if(re[contador][2] == rc[contador]) {
                puntuacion += 1

                color2 = when (color2) {
                    colour -> verde
                    else -> colour
                }

            }else {
                color2 = when (color2) {
                    colour -> rojo
                    else -> colour
                }
            }
        }) {
        Text(text = re[contador][2])
    }

    Button( modifier = Modifier.padding(top = 20.dp) ,
        enabled = !enabled,
        onClick = {
            if(cont<pr.size) {
                enabled = !enabled
                contador += 1

                color = when (color) {
                    colour -> colour
                    else -> colour
                }

                color1 = when (color1) {
                    colour -> colour
                    else -> colour
                }

                color2 = when (color2) {
                    colour -> colour
                    else -> colour
                }

            }else {
                enabled = !enabled
                contador = 0
                puntuacion = 0

                color = when (color) {
                    colour -> colour
                    else -> colour
                }

                color1 = when (color1) {
                    colour -> colour
                    else -> colour
                }

                color2 = when (color2) {
                    colour -> colour
                    else -> colour
                }

            }

        },

        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)) {
        Text(text = "Siguiente")
    }
    Text(text = "Tu puntuación es de " + puntuacion)
}