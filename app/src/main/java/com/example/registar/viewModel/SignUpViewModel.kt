package com.example.registar.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registar.database.Users
import com.example.registar.database.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private var usersUseCase: UsersUseCase) : ViewModel() {

    private val _insertUsersDataStatus = MutableLiveData<Long>()

    val insertUsersDataStatus: LiveData<Long> = _insertUsersDataStatus

    private val _insertUsersDataStatusList = MutableLiveData<List<Long>>()

    val insertUsersDataStatusList: LiveData<Long> = _insertUsersDataStatus

    fun insertUserData(users: Users) {
        viewModelScope.launch {
            try {
                val data = usersUseCase.addUser(users)
            } catch (exception: Exception) {
                Log.d("error", exception.toString())
            }
        }
    }

    fun checkIfAccountExist(email: String) {
        viewModelScope.launch {
            try {
                val data = usersUseCase.getUserLoginVerify(email = email)
            } catch (exception: Exception) {
                Log.d("error", exception.toString())
            }
        }
    }

}