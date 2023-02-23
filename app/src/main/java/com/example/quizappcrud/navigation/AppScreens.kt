package com.example.quizappcrud.navigation

sealed class AppScreens(val ruta:String) {
    object Menu : AppScreens("Menu")
    object GuardarDatos : AppScreens("GuardarDatos")
    object ModificarDatos : AppScreens("ModificarDatos")
    object EliminarDatos : AppScreens("EliminarDatos")
    object InformeDatos : AppScreens("InformeDatos")
    object ConsultarDatos : AppScreens("ConsultarDatos")
    object LoginScreen : AppScreens("LoginScreen")
    object RegisterScreen : AppScreens("RegisterScreen")
    object MenuUser : AppScreens("MenuUser")
    object Test: AppScreens("AppScreens")
    object End: AppScreens("End")
}