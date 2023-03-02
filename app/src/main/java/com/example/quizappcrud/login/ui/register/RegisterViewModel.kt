package com.example.quizappcrud.login.ui.register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay

class RegisterViewModel : ViewModel(){

    private val _nombre = MutableLiveData<String>()
    val nombre : LiveData<String> = _nombre
    val nombreUsuario = nombre.value.toString()

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

    private val _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> = _isButtonEnable

    private val _confirmation_message = MutableLiveData<String>()
    val confirmation_message: LiveData<String> = _confirmation_message

    private val _detectorConsulta = MutableLiveData<Boolean>()
    var detectorConsulta: LiveData<Boolean> = _detectorConsulta


    fun onCompletedFields(nombre:String, apellidos:String, edad:String, nacionalidad : String, email: String, password: String){
        _nombre.value = nombre
        _apellidos.value = apellidos
        _edad.value = edad
        _nacionalidad.value = nacionalidad
        _email.value = email
        _password.value = password
        _isButtonEnable.value = isValidNombre(nombre) && isValidApellidos(apellidos) && isValidEdad(edad) && isValidNacionalidad(nacionalidad) && isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidNacionalidad(nacionalidad: String): Boolean = nacionalidad.length > 0

    private fun isValidEdad(edad: String): Boolean = edad.length > 0

    private fun isValidApellidos(apellidos: String): Boolean = apellidos.length > 0

    private fun isValidNombre(nombre: String): Boolean = nombre.length > 0

    fun registerButton(db: FirebaseFirestore, nombre_coleccion: String, email: String, dato: HashMap<String, String>){

        consultarEmail(db,nombre_coleccion, email)

        if(_detectorConsulta.value == true){
            db.collection(nombre_coleccion)
                .document(email)
                .set(dato)
                .addOnSuccessListener {
                    buttonSuccess()
                }
                .addOnFailureListener {
                    buttonFail()
                }
        }else if(_detectorConsulta.value == false){
            buttonFail()
        }



    }

    private fun buttonFail() {
        _confirmation_message.value = "ERROR: Ha habido un error. Por favor inténtelo de nuevo o más tarde."
    }

    private fun buttonSuccess() {
        _confirmation_message.value = "ÉXITO: Datos guardados en la base de datos."
        _nombre.value = ""
        _apellidos.value = ""
        _edad.value = ""
        _nacionalidad.value = ""
        _email.value = ""
        _password.value = ""
    }

    fun consultarEmail(db: FirebaseFirestore, nombre_coleccion:String, email: String){

        db.collection(nombre_coleccion)
            .document(email)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    _detectorConsulta.value = false
                } else {
                    _detectorConsulta.value = true
                }
            }
            .addOnFailureListener {
                _detectorConsulta.value = false
            }

    }

    fun rutaButton(navController: NavHostController, ruta:String){
        navController.navigate(ruta)
    }
}