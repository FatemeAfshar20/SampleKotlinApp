package com.utab.samplekotlinapp.network

import com.utab.samplekotlinapp.data.FlickerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RetrofitInterface {
    @GET(".")
    fun getPosts(@QueryMap queryMap: Map<String,String>): Call<FlickerResponse>
}