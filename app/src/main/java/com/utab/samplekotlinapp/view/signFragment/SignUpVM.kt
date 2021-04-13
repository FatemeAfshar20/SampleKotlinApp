package com.utab.samplekotlinapp.view.signFragment

import android.text.Editable
import com.utab.samplekotlinapp.data.User
import com.utab.samplekotlinapp.repository.UserRepository

class SignUpVM(private var repository:UserRepository) {
    private var user= User()

    fun afterTextChangedUserName(editable: Editable){
        user.userName=editable.toString()
    }

    fun afterTextChangedEmail(editable: Editable){
        user.email=editable.toString()
    }

    fun afterTextChangedPass(editable: Editable){
        user.password=editable.toString()
    }

    fun afterTextChangedJob(editable: Editable){
        user.job=editable.toString()
    }

    fun onSignBtnClickListener(){
        repository.setUser(user)
    }
}