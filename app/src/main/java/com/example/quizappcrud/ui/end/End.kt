package com.example.quizappcrud.ui.end

import android.view.View
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizappcrud.R
import com.example.quizappcrud.ui.test.ViewModelTest

@Composable
fun End(ViewModelEnd:ViewModelEnd,ViewModelTest: ViewModelTest, navController: NavHostController) {

    val puntuacion:Int by ViewModelTest.puntuacion.observeAsState (initial = 0)

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
                Text(   text = "Resultado: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 6.dp))

                Text(   text = "Tu puntuación ha sido " + puntuacion,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 15.dp))
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    onClick = {
                        ViewModelEnd.rutaButton(navController, "Inicio")
                    }) {
                    Text(text = "Inicio")
                }

            }
        }
    }
}