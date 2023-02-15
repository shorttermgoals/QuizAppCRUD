package com.example.quizappcrud.login.ui.register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay

class RegisterViewModel : ViewModel(){

    private val _nombre = MutableLiveData<String>()
    val nombre : LiveData<String> = _nombre

    private val _apellidos = MutableLiveData<String>()
    val apellidos : LiveData<String> = _apellidos

    private val _edad = MutableLiveData<String>()
    val edad : LiveData<String> = _edad

    private val _nacionalidad = MutableLiveData<String>()
    val nacionalidad : LiveData<String> = _nacionalidad

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _registerEnable = MutableLiveData<Boolean>()
    val registerEnable : LiveData<Boolean> = _registerEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _confirmation_message = MutableLiveData<String>()
    val confirmation_message: LiveData<String> = _confirmation_message


    fun onRegisterChanged(nombre:String, apellidos:String, edad:String, nacionalidad : String, email: String, password: String){
        _nombre.value = nombre
        _apellidos.value = apellidos
        _edad.value = edad
        _nacionalidad.value = nacionalidad
        _email.value = email
        _password.value = password
        _registerEnable.value = isValidNombre(nombre) && isValidApellidos(apellidos) && isValidEdad(edad) && isValidNacionalidad(nacionalidad) && isValidEmail(email) && isValidPassword(password)
    }

    suspend fun onRegisterSelected(){
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidNacionalidad(nacionalidad: String): Boolean = nacionalidad.length > 0

    private fun isValidEdad(edad: String): Boolean = edad.length > 0

    private fun isValidApellidos(apellidos: String): Boolean = apellidos.length > 0

    private fun isValidNombre(nombre: String): Boolean = nombre.length > 0

    fun registerButton(db: FirebaseFirestore, nombre_coleccion: String, email: String, dato: HashMap<String, String>){
        db.collection(nombre_coleccion)
            .document(email)
            .set(dato)

    }
}