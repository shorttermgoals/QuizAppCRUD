package com.example.quizappcrud.navigation

import LoginViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizappcrud.crud.consultar.ConsultarDatos
import com.example.quizappcrud.crud.consultar.ViewModelConsultar
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
import com.example.quizappcrud.login.ui.login.LoginScreen
import com.example.quizappcrud.login.ui.register.RegisterScreen
import com.example.quizappcrud.login.ui.register.RegisterViewModel
import com.example.quizappcrud.ui.end.End
import com.example.quizappcrud.ui.end.ViewModelEnd
import com.example.quizappcrud.ui.menuUser.MenuUser
import com.example.quizappcrud.ui.menuUser.ViewModelMenuUser
import com.example.quizappcrud.ui.test.Test
import com.example.quizappcrud.ui.test.ViewModelTest

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.RegisterScreen.ruta) {

        composable(AppScreens.Menu.ruta) { Menu(ViewModelMenu(), navController) }
        composable(AppScreens.GuardarDatos.ruta) { GuardarDatos(ViewModelGuardar(), navController) }
        composable(AppScreens.ModificarDatos.ruta) { ModificarDatos(ViewModelModificar(), navController) }
        composable(AppScreens.EliminarDatos.ruta) { EliminarDatos(ViewModelEliminar(), navController) }
        composable(AppScreens.InformeDatos.ruta) { InformeDatos(ViewModelInforme(), navController) }
        composable(AppScreens.ConsultarDatos.ruta) { ConsultarDatos(ViewModelConsultar(), navController)}
        composable(AppScreens.LoginScreen.ruta) { LoginScreen(navController, LoginViewModel()) }
        composable(AppScreens.RegisterScreen.ruta) { RegisterScreen(RegisterViewModel(), navController) }
        composable(AppScreens.MenuUser.ruta) { MenuUser(ViewModelMenuUser(), navController, LoginViewModel(), RegisterViewModel())}
        composable(AppScreens.Test.ruta) { Test(ViewModelTest(), navController) }
        composable(AppScreens.End.ruta) { End( ViewModelEnd(), ViewModelTest(), navController)}

    }
}