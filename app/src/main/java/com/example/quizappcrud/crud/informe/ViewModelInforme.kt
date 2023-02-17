package com.example.quizappcrud.crud.informe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class ViewModelInforme:ViewModel() {

    private val _datos = MutableLiveData<String>()
    val datos : LiveData<String> = _datos

    fun informeButton(db: FirebaseFirestore, nombre_coleccion:String) {
        _datos.value = ""
        db.collection(nombre_coleccion)
            .get()
            .addOnSuccessListener { resultado ->
                for (encontrado in resultado) {

                    _datos.value += "ID: ${encontrado.getString("id")}\n"
                    _datos.value += "Pregunta: ${encontrado.getString("pregunta")}\n"
                    _datos.value += "Respuesta 1: ${encontrado.getString("respuesta1")}\n"
                    _datos.value += "Respuesta 2: ${encontrado.getString("respuesta2")}\n"
                    _datos.value += "Respuesta 3: ${encontrado.getString("respuesta3")}\n\n"
                    _datos.value += "Respuesta correcta: ${encontrado.getString("respuestaCorrecta")}\n\n"

                }

                if (_datos.toString().isEmpty()) {
                    _datos.value = "ERROR: No existen datos en la base de datos."
                }
            }
            .addOnFailureListener { resultado ->
                _datos.value = "ERROR: Ha habido un error. Por favor inténtelo de nuevo o más tarde."
            }
    }
}