package com.example.quizappcrud.ui.test

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizappcrud.crud.db
import com.example.quizappcrud.crud.informe.ViewModelInforme
import com.example.quizappcrud.crud.nombre_coleccion

class ViewModelTest:ViewModel() {

    private val _puntuacion = MutableLiveData<Int>()
    val puntuacion : LiveData<Int> = _puntuacion

    private val _contador = MutableLiveData<Int>()
    val contador : LiveData<Int> = _contador

    private val _enabled = MutableLiveData<Boolean>()
    val enabled : LiveData<Boolean> = _enabled



}