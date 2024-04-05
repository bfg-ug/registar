package com.example.registar.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.registar.utility.Screens


@Composable
fun Homepage(navController: NavController){
    Surface(color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()) {

        Column (
            modifier= Modifier
                .padding(50.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center){

            Row(horizontalArrangement = Arrangement.Center){
                Text(text ="Welcome ", fontSize = 34.sp)
                Text(text ="World", fontSize = 34.sp)
            }

            Text(text = "Thank you for signing up with us your data is safe with us", fontSize = 18.sp, modifier = Modifier.padding(vertical = 16.dp))

            OutlinedButton(onClick = {navController.navigate(Screens.signInScreen.route)}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sign out")
                
            }
        }

    }
}
