package com.utab.samplekotlinapp.view.loginFragment

import android.text.Editable
import com.utab.samplekotlinapp.data.User
import com.utab.samplekotlinapp.repository.UserRepository

class LoginVm(private var repository:UserRepository) {
    private var user= User()

    fun afterTextChangedUserName(editable: Editable){
        user.userName=editable.toString()
    }

    fun afterTextChangedPass(editable: Editable){
        user.password=editable.toString()
    }

    fun checkInputInfo():Boolean{
        return repository.getUser().userName == user.userName
                && repository.getUser().password == user.password
    }
}