package com.example.quizappcrud.ui.menuUser

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class ViewModelMenuUser:ViewModel() {
    fun rutaButton(navController: NavHostController, ruta:String){
        navController.navigate(ruta)
    }
}