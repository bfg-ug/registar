package com.example.registar.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.registar.database.Users
import com.example.registar.ui.theme.reddish
import com.example.registar.utility.Screens
import com.example.registar.viewModel.SignUpViewModel


@Composable
fun SignUpPage(navController: NavController, signUpViewModel: SignUpViewModel){
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "Sign up", fontSize = 30.sp)
           Icon(Icons.Default.AccountBox , contentDescription = null, modifier = Modifier
               .padding(vertical = 20.dp)
               .size(80.dp) )

            OutlinedTextField(value = name , onValueChange = { name = it }, modifier = Modifier.padding(top = 16.dp), label = { Text(text = "Full name")},leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "personIcon") } )
            OutlinedTextField(value = email , onValueChange = { email = it }, modifier = Modifier.padding(top = 16.dp), label = { Text(text = "Email")},leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") } )
            OutlinedTextField(value = password ,
                onValueChange = {password = it},
                modifier = Modifier.padding(top = 16.dp),
                label = { Text(text = "Password")},
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "lockIcon") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                })


            OutlinedTextField(value = confirmPassword,
                onValueChange = {confirmPassword = it},
                modifier = Modifier.padding(top = 16.dp),
                label = { Text(text = "Confirm Password")},
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "lockIcon") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                })








            OutlinedButton(onClick = {
                if(password == confirmPassword){
                    var user = Users(name = name.text, email = email.text, password = confirmPassword.text)

                    signUpViewModel.insertUserData(user)

                    navController.navigate(Screens.signInScreen.route)
                }

                }, modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()) {

                Text(text = "Create account")
                
            }

            Row {
                Text(text = "Already have an account? ")
                Text(text = "Sign in", color = reddish,modifier = Modifier
                    .clickable {
                        navController.navigate(Screens.signInScreen.route)
                    })
            }
        }

    }
}