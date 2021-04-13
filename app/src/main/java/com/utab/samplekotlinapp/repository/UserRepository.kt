package com.utab.samplekotlinapp.repository

import com.utab.samplekotlinapp.data.User

object UserRepository {
    private var user = User()

    fun setUser(user: User) {
        this.user = user
    }

    fun getUser(): User {
        return user
    }
}