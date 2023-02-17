package com.example.quizappcrud.ui.inicio

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class ViewModelInicio: ViewModel() {
    fun rutaButton(navController: NavHostController, ruta:String){
        navController.navigate(ruta)
    }
}