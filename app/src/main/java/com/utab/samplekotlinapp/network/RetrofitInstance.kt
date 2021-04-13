package com.utab.samplekotlinapp.network

import com.utab.samplekotlinapp.utils.NetworkUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

        fun getRetrofit(): Retrofit{
            return Retrofit.Builder().
            baseUrl(NetworkUtils.URL).
            addConverterFactory(GsonConverterFactory.create()).
            build()
        }
}