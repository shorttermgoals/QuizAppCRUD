package com.example.quizappcrud.crud

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class ViewModelConsultar:ViewModel(){
    private val _id = MutableLiveData<String>()
    val id : LiveData<String> = _id

    private val _datos = MutableLiveData<String>()
    val datos : LiveData<String> = _datos

    private val _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> = _isButtonEnable


    fun onCompletedFields(id:String) {
        _id.value = id
        _isButtonEnable.value = enableButton(id)
    }

    fun enableButton(id:String) =
        id.length>0


    fun consultarButton(db: FirebaseFirestore, nombre_coleccion:String, id: String) {
        _datos.value = ""
        db.collection(nombre_coleccion)
            .document(id)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    _datos.value += "ID: ${documentSnapshot.getString("id")}\n"
                    _datos.value += "Pregunta: ${documentSnapshot.getString("pregunta")}\n"
                    _datos.value += "Respuesta 1: ${documentSnapshot.getString("respuesta1")}\n"
                    _datos.value += "Respuesta 2: ${documentSnapshot.getString("respuesta2")}\n"
                    _datos.value += "Respuesta 3: ${documentSnapshot.getString("respuesta3")}\n"
                    _datos.value += "Respuesta correcta: ${documentSnapshot.getString("respuestaCorrecta")}\n"
                } else {
                    _datos.value = "ERROR: El coche buscado no existe en la base de datos."
                }
            }
            .addOnFailureListener {
                _datos.value = "ERROR: Ha habido un error. Por favor inténtelo de nuevo o más tarde."
            }
    }
}