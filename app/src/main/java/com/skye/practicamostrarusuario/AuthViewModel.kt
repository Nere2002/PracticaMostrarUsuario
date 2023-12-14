package com.skye.practicamostrarusuario

import LoginFragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    val authResult = MutableLiveData<Boolean>()

//    private var _user = ""
//    val user: String
//        get() = _user
//
//    private var _password = ""
//    val password: String
//        get() = _password
//
//    fun llistaUsuaris() {
//        val loginFragment = LoginFragment()
//        val users = loginFragment.users
//    }
//
//    fun mostrarUser() {
//        val currentUser = llistaUsuaris()
//        _user = currentUser.
//    }


    fun loginUser(username: String, password: String, userList: List<User>): Boolean {
        // Authentication logic here
        val isValidUser = userList.any { it.username == username && it.password == password }
        authResult.value = isValidUser
        return isValidUser
    }
}
