package com.example.quizappcrud.ui.end

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class ViewModelEnd:ViewModel() {
    fun rutaButton(navController: NavHostController, ruta:String){
        navController.navigate(ruta)
    }
}