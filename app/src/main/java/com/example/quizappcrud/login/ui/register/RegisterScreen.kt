package com.example.quizappcrud.login.ui.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.quizappcrud.R
import com.example.quizappcrud.login.data.db
import com.example.quizappcrud.login.data.nombre_coleccion
import com.example.quizappcrud.login.ui.login.*
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(RegisterViewModel: RegisterViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)){
        Register(Modifier.align(Alignment.Center), RegisterViewModel)
    }
}

@Composable
fun Register(modifier: Modifier, RegisterViewModel: RegisterViewModel) {
    val nombre:String by RegisterViewModel.nombre.observeAsState(initial = "")
    val apellidos:String by RegisterViewModel.apellidos.observeAsState(initial = "")
    val edad:String by RegisterViewModel.edad.observeAsState(initial = "")
    val nacionalidad:String by RegisterViewModel.nacionalidad.observeAsState(initial = "")
    val email:String by RegisterViewModel.email.observeAsState(initial = "")
    val password:String by RegisterViewModel.password.observeAsState(initial = "")
    val registerEnable:Boolean by RegisterViewModel.registerEnable.observeAsState(initial = false)
    val isLoading:Boolean by RegisterViewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if(isLoading){
        Box(Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }else{
        Column(modifier = Modifier) {
            HeaderImage(modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            NameField(nombre){ RegisterViewModel.onRegisterChanged(it, apellidos, edad, nacionalidad, email, password) }
            Spacer(modifier = Modifier.padding(4.dp))
            SurnameField(apellidos){ RegisterViewModel.onRegisterChanged(nombre,it, edad, nacionalidad, email, password) }
            Spacer(modifier = Modifier.padding(8.dp))
            AgeField(edad){ RegisterViewModel.onRegisterChanged(nombre, apellidos, it, nacionalidad, email, password) }
            Spacer(modifier = Modifier.padding(8.dp))
            NationalityField(nacionalidad){ RegisterViewModel.onRegisterChanged(nombre,apellidos, edad, it, email, password) }
            Spacer(modifier = Modifier.padding(8.dp))
            EmailField(email){ RegisterViewModel.onRegisterChanged(nombre,it, edad, nacionalidad, it, password) }
            Spacer(modifier = Modifier.padding(8.dp))
            PasswordField(password){ RegisterViewModel.onRegisterChanged(nombre,it, edad, nacionalidad, email, it) }
            Spacer(modifier = Modifier.padding(16.dp))
            RegisterButton(RegisterViewModel(),registerEnable){ coroutineScope.launch{
                RegisterViewModel.onRegisterSelected()
            } }
        }


    }
}

@Composable
fun RegisterButton(RegisterViewModel: RegisterViewModel, registerEnable: Boolean, onRegisterSelected: () -> Unit) {
    Button(
        onClick = {

        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4D068B),
            disabledBackgroundColor = Color(0xFF6700C0),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ), enabled = registerEnable
    ){
        Text(text = "Registrar")
    }
}

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value =password , onValueChange ={onTextFieldChanged(it)},
        placeholder = { Text(text = "Contraseña")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun EmailField(email: String, onTextFieldChanged:(String)->Unit) {
    TextField(value = email , onValueChange ={ onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun NationalityField(nacionalidad: String, onTextFieldChanged: (String) -> Unit) {
    TextField(value = nacionalidad , onValueChange ={ onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Nacionalidad") },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun AgeField(edad: String, onTextFieldChanged: (String) -> Unit) {
    TextField(value = edad , onValueChange ={ onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Edad") },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun SurnameField(apellidos: String, onTextFieldChanged: (String) -> Unit) {
    TextField(value = apellidos , onValueChange ={ onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Apellidos") },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun NameField(nombre: String, onTextFieldChanged: (String) -> Unit) {
    TextField(value = nombre , onValueChange ={ onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Nombre") },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_app___copia),
        contentDescription = "Header",
        modifier = modifier )
}



