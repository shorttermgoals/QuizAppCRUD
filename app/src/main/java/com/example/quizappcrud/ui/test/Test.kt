package com.example.quizappcrud.ui.test

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizappcrud.crud.consultar.ViewModelConsultar
import com.example.quizappcrud.crud.db
import com.example.quizappcrud.crud.informe.ViewModelInforme
import com.example.quizappcrud.crud.nombre_coleccion
import java.util.regex.Pattern
import kotlin.streams.toList

@Composable
fun Test(ViewModelTest:ViewModelTest, navController: NavHostController) {
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

            Botones(ViewModelTest(),ViewModelInforme())

        }
    }
}

@Composable
fun Botones(ViewModelTest: ViewModelTest, ViewModelInforme: ViewModelInforme){

    var preguntas = ViewModelInforme.informePreguntas(db, nombre_coleccion)
    val listaPreguntas = preguntas.toString().split(",").toList()
    var respuestas1 = ViewModelInforme.informeRespuesta1(db, nombre_coleccion)
    val listaRespuestas1 = respuestas1.toString().split(",").toList()
    var respuestas2 = ViewModelInforme.informeRespuesta2(db, nombre_coleccion)
    val listaRespuestas2 = respuestas2.toString().split(",").toList()
    var respuestas3 = ViewModelInforme.informeRespuesta3(db, nombre_coleccion)
    val listaRespuestas3 = respuestas3.toString().split(",").toList()
    var respuestasCorrectas = ViewModelInforme.informeRespuestaCorrecta(db, nombre_coleccion)
    val listaRespuestasCorrectas = respuestasCorrectas.toString().split(",").toList()

    var contador: Int by remember { mutableStateOf(0) }
    var puntuacion: Int by remember { mutableStateOf(0) }
    var enabled by remember { mutableStateOf(true) }

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
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
    )
    Text(   text = listaPreguntas[contador],
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth())

    Button(modifier = Modifier
        .border(10.dp, color)
        .fillMaxWidth()
        .padding(top = 15.dp),
        enabled = enabled,
        onClick = {
            enabled = !enabled
            if(listaRespuestas1[contador] == listaRespuestasCorrectas[contador] || listaRespuestas2[contador] == listaRespuestasCorrectas[contador] || listaRespuestas3[contador] == listaRespuestasCorrectas[contador]) {
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
        Text(text = listaRespuestas1[contador])
    }

    Button(modifier = Modifier
        .border(10.dp, color1)
        .fillMaxWidth()
        .padding(top = 15.dp),
        enabled = enabled,
        onClick = {
            enabled = !enabled
            if(listaRespuestas1[contador] == listaRespuestasCorrectas[contador] || listaRespuestas2[contador] == listaRespuestasCorrectas[contador] || listaRespuestas3[contador] == listaRespuestasCorrectas[contador]) {
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
        Text(text = listaRespuestas2[contador])
    }

    Button(modifier = Modifier
        .border(10.dp, color2)
        .fillMaxWidth()
        .padding(top = 15.dp),
        enabled = enabled,
        onClick = {
            enabled = !enabled
            if(listaRespuestas1[contador] == listaRespuestasCorrectas[contador] || listaRespuestas2[contador] == listaRespuestasCorrectas[contador] || listaRespuestas3[contador] == listaRespuestasCorrectas[contador]) {
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
        Text(text = listaRespuestas3[contador])
    }

    Button( modifier = Modifier.padding(top = 20.dp) ,
        enabled = !enabled,
        onClick = {
            if(cont<listaPreguntas.size) {
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
}