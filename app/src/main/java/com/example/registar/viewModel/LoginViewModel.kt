package com.example.registar.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registar.database.Users
import com.example.registar.database.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(var usersUseCase: UsersUseCase): ViewModel() {
    private val _GetUserLoginDataStatus = MutableLiveData<Users>()

    val getUserLoginDataStatus: MutableLiveData<Users> = _GetUserLoginDataStatus

    private val _GetUserProfileDataStatus = MutableLiveData<Users>()

    val getUserProfileDataStatus: MutableLiveData<Users> = _GetUserProfileDataStatus


    fun getUserLoginDataStatus(email:String) {
        viewModelScope.launch {
            try {
                val data = usersUseCase.getUserLoginVerify(email)
            } catch (exception: Exception) {
                Log.d("error", exception.toString())
            }
        }
    }

    fun getUserProfileData(id:Long){
        viewModelScope.launch {
            try {
                val data = usersUseCase.getUserData(id)
            } catch (exception: Exception) {
                Log.d("error", exception.toString())
            }
        }
    }


}