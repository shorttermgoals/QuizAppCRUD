package com.example.quizappcrud.crud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizappcrud.crud.eliminar.EliminarDatos
import com.example.quizappcrud.crud.eliminar.ViewModelEliminar
import com.example.quizappcrud.crud.guardar.GuardarDatos
import com.example.quizappcrud.crud.guardar.ViewModelGuardar
import com.example.quizappcrud.crud.informe.InformeDatos
import com.example.quizappcrud.crud.informe.ViewModelInforme
import com.example.quizappcrud.crud.menu.Menu
import com.example.quizappcrud.crud.menu.ViewModelMenu
import com.example.quizappcrud.crud.modificar.ModificarDatos
import com.example.quizappcrud.crud.modificar.ViewModelModificar

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.Menu.ruta)

    {

        composable(AppScreens.Menu.ruta) { Menu(ViewModelMenu(), navigationController) }
        composable(AppScreens.GuardarDatos.ruta) { GuardarDatos(ViewModelGuardar()) }
        composable(AppScreens.ModificarDatos.ruta) { ModificarDatos(ViewModelModificar()) }
        composable(AppScreens.EliminarDatos.ruta) { EliminarDatos(ViewModelEliminar()) }
        composable(AppScreens.InformeDatos.ruta) { InformeDatos(ViewModelInforme()) }

    }
}