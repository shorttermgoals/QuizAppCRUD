package com.example.quizappcrud.login.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay

class LoginViewModel : ViewModel(){

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> = _isButtonEnable

    private val _confirmation_message = MutableLiveData<String>()
    val confirmation_message: LiveData<String> = _confirmation_message

    private val _detectorConsultaDatos = MutableLiveData<Boolean>()
    var detectorConsultaDatos: LiveData<Boolean> = _detectorConsultaDatos

    private val _email2 = MutableLiveData<String>()
    val email2 : LiveData<String> = _email2

    private val _pw2 = MutableLiveData<String>()
    val pw2 : LiveData<String> = _pw2

    fun onCompletedFields(email: String, password: String){
        _email.value = email
        _password.value = password
        _isButtonEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun loginButton(db: FirebaseFirestore, nombre_coleccion:String, email: String){
        consultarDatos(db, nombre_coleccion, email)

        if(_detectorConsultaDatos.value == true){
            _confirmation_message.value = "Login completado con éxito"
            navegarMenuJuego()
        }
    }

    fun navegarMenuJuego() {
        TODO("Not yet implemented")
    }

    fun buttonSuccess(){
        _confirmation_message.value = "Login completado."
        _email.value = ""
        _password.value = ""
    }
    fun buttonFail(){
        _confirmation_message.value = "ERROR: Ha habido un error. Por favor inténtelo de nuevo o más tarde."
    }

    fun consultarDatos(db: FirebaseFirestore, nombre_coleccion:String, email: String){

        _email2.value = ""
        _pw2.value = ""

        db.collection(nombre_coleccion)
            .document(email)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    _email2.value = "${documentSnapshot.getString("email")}"
                    _pw2.value = "${documentSnapshot.getString("password")}"
                    if(_email2.value == _email.value && _pw2.value == _password.value){
                        _detectorConsultaDatos.value = true
                    }
                } else {
                    _confirmation_message.value = "ERROR: El dato buscado no existe en la base de datos."
                }
            }
            .addOnFailureListener {
                _confirmation_message.value = "ERROR: Ha habido un error. Por favor inténtelo de nuevo o más tarde."
            }
    }

    fun rutaButton(navController: NavHostController, ruta:String){
        navController.navigate(ruta)
    }

}