package com.example.quizappcrud.crud.navigation

sealed class AppScreens(val ruta:String) {
    object Menu: AppScreens("Menu")
    object GuardarDatos: AppScreens("GuardarDatos")
    object ModificarDatos: AppScreens("ModificarDatos")
    object EliminarDatos: AppScreens("EliminarDatos")
    object InformeDatos: AppScreens("InformeDatos")
}