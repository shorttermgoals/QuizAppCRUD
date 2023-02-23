package com.example.quizappcrud.crud.eliminar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore


class ViewModelEliminar: ViewModel() {
    private val _id = MutableLiveData<String>()
    val id : LiveData<String> = _id

    private val _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> = _isButtonEnable

    private val _confirmation_message = MutableLiveData<String>()
    val confirmation_message: LiveData<String> = _confirmation_message

    fun onCompletedFields(id:String) {
        _id.value = id
        _isButtonEnable.value = enableButton(id)
        _confirmation_message.value = ""
    }

    fun enableButton(id:String) =
        id.length>0


    fun eliminarButton(db: FirebaseFirestore, nombre_coleccion:String, id: String) {
        db.collection(nombre_coleccion)
            .document(id)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    documentSnapshot.reference.delete()
                        .addOnSuccessListener {
                            _confirmation_message.value = "ÉXITO: Dato borrado de la base de datos."
                            _id.value = ""
                        }
                        .addOnFailureListener {
                            _confirmation_message.value = "ERROR: Ha habido un error. Por favor inténtelo de nuevo o más tarde."
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