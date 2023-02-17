package com.example.quizappcrud.crud.menu

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class ViewModelMenu: ViewModel() {
    fun rutaButton(navController: NavHostController, ruta:String){
        navController.navigate(ruta)
    }
}
