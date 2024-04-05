package com.example.registar.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.registar.utility.Screens


@Composable
fun ForgotPassord(navController: NavController) {

    var text by remember { mutableStateOf(TextFieldValue("")) }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(50.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "Reset password", fontSize = 30.sp)
            Icon(
                Icons.Default.Lock, contentDescription = null, modifier = Modifier
                    .padding(vertical = 20.dp)
                    .size(80.dp) )

            OutlinedTextField(value = text, leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },

                onValueChange = {
                                text = it
                }, modifier = Modifier.padding(vertical = 16.dp), label = {
                Text(
                text = "Email"
            )} )



            OutlinedButton(onClick = {
                navController.navigate(Screens.signInScreen.route)
            }, modifier = Modifier.fillMaxWidth()) {

                Text(text = "Reset password")

            }
        }

    }
}