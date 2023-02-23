package com.example.quizappcrud.crud.modificar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore

class ViewModelModificar: ViewModel() {

    private val _idBusqueda = MutableLiveData<String>()
    val idBusqueda : LiveData<String> = _idBusqueda

    private val _id = MutableLiveData<String>()
    val id : LiveData<String> = _id

    private val _pregunta = MutableLiveData<String>()
    val pregunta : LiveData<String> = _pregunta

    private val _respuesta1 = MutableLiveData<String>()
    val respuesta1 : LiveData<String> = _respuesta1

    private val _respuesta2 = MutableLiveData<String>()
    val respuesta2 : LiveData<String> = _respuesta2

    private val _respuesta3 = MutableLiveData<String>()
    val respuesta3 : LiveData<String> = _respuesta3

    private val _respuestaCorrecta = MutableLiveData<String>()
    val respuestaCorrecta: LiveData<String> = _respuestaCorrecta

    private val _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> = _isButtonEnable

    private val _confirmation_message = MutableLiveData<String>()
    val confirmation_message: LiveData<String> = _confirmation_message

    fun onCompletedFields(idBusqueda:String, id:String, pregunta:String, respuesta1:String, respuesta2:String, respuesta3:String, respuestaCorrecta:String) {
        _idBusqueda.value = idBusqueda
        _id.value = id
        _pregunta.value = pregunta
        _respuesta1.value = respuesta1
        _respuesta2.value = respuesta2
        _respuesta3.value = respuesta3
        _respuestaCorrecta.value = respuestaCorrecta
        _isButtonEnable.value = enableButton(idBusqueda,id, pregunta, respuesta1, respuesta2, respuesta3, respuestaCorrecta)
        _confirmation_message.value = ""
    }

    fun enableButton(idBusqueda: String, id:String, pregunta: String, respuesta1: String, respuesta2: String, respuesta3: String, respuestaCorrecta: String) =
        idBusqueda.length>0 && id.length>0 && pregunta.length>0 && respuesta1.length>0 && respuesta2.length>0 && respuesta3.length>0 && respuestaCorrecta.length>0 && isValidRespuestas(respuesta1
            ,respuesta2,respuesta3,respuestaCorrecta)


    fun modificarButton(db: FirebaseFirestore, nombre_coleccion:String, idBusqueda: String, dato: HashMap<String, String>) {
        db.collection(nombre_coleccion)
            .document(idBusqueda)
            .get()
            .addOnSuccessListener { documentSnapshot ->

                //COMPRUEBA QUE EL IDBUSCADO (ID A MODIFICAR) EXISTE EN LA BBDD
                if (documentSnapshot.exists()) {

                    //COMPRUEBA QUE EL NUEVO ID NO EXISTE YA EN LA BBDD PUES DEBE SER ÚNICO, SALVO QUE DICHO ID SEA IGUAL AL IDBUSCADO (NO HAY MODIFICACION DE ID)
                    if (documentSnapshot.data?.get("id") != id.toString() || idBusqueda == id.toString()) {
                        db.collection(nombre_coleccion)
                            .document(idBusqueda)
                            .set(dato)
                            .addOnSuccessListener {
                                buttonSuccess()
                            }
                            .addOnFailureListener {
                                buttonFail()
                            }
                    } else {
                        _confirmation_message.value = "ERROR: Nuevo ID introducido ya existe."
                    }
                } else {
                    _confirmation_message.value = "ERROR: El dato buscado no existe en la base de datos."
                }
            }
            .addOnFailureListener {
                _confirmation_message.value = "ERROR: Ha habido un error. Por favor inténtelo de nuevo o más tarde."
            }
    }
    fun buttonSuccess(){
        _confirmation_message.value = "ÉXITO: Datos guardados en la base de datos."
        _idBusqueda.value = ""
        _id.value = ""
        _pregunta.value = ""
        _respuesta1.value = ""
        _respuesta2.value = ""
        _respuesta3.value = ""
        _respuestaCorrecta.value = ""
    }
    fun buttonFail(){
        _confirmation_message.value = "ERROR: Ha habido un error. Por favor inténtelo de nuevo o más tarde."
    }


    fun isValidRespuestas(respuesta1: String, respuesta2: String, respuesta3: String, respuestaCorrecta: String): Boolean {

        if (respuesta1 == respuestaCorrecta || respuesta2 == respuestaCorrecta || respuesta3 == respuestaCorrecta){
            return true
        }
        return false
    }

    fun rutaButton(navController: NavHostController, ruta:String){
        navController.navigate(ruta)
    }
}