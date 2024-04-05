package com.example.registar.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.registar.ui.theme.reddish
import com.example.registar.utility.Screens


@Composable
fun SignInPage(navController: NavController){
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
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
            Text(text = "Sign In", fontSize = 30.sp)
            Icon(Icons.Default.Person , contentDescription = null, modifier = Modifier
                .padding(vertical = 20.dp)
                .size(80.dp) )

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


            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Forgot password", fontSize = 12.sp, fontStyle = FontStyle.Italic, modifier = Modifier
                    .clickable { navController.navigate(Screens.forgotPasswordScreen.route) }
                    .padding(end = 2.dp))
            }


            OutlinedButton(onClick = {
                                     navController.navigate(Screens.homeScreen.route)
            }, modifier = Modifier.fillMaxWidth()) {

                Text(text = "Login")

            }
            Text(text = "or", modifier = Modifier.padding(vertical = 20.dp))

            Row {
                Text(text = "Don't have an account? ")
                Text(text = "Create account", color = reddish,modifier = Modifier
                    .clickable {
                        navController.navigate(Screens.signUpScreen.route)
                    })
            }
        }

    }
}