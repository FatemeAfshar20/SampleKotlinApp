package com.utab.samplekotlinapp.repository

import android.util.Log
import com.utab.samplekotlinapp.data.PhotoItem
import com.utab.samplekotlinapp.network.RetrofitInterface
import com.utab.samplekotlinapp.utils.NetworkUtils
import com.utab.samplekotlinapp.utils.ProgramUtils
import retrofit2.Retrofit

object PostInfoRepository {
    var userOneImages =mutableListOf<PhotoItem>()
    var userTwoImages = mutableListOf<PhotoItem>()
    var userThreeImages = mutableListOf<PhotoItem>()
    var userFourImages = mutableListOf<PhotoItem>()
    var userFiveImages = mutableListOf<PhotoItem>()
    private lateinit var retrofit: Retrofit
    var listOfPhotoItem = mutableListOf<PhotoItem>()

    fun requestServerReceivePosts(userId: String) {
        val call = retrofit.create(RetrofitInterface::class.java)

        val response = call.getPosts(NetworkUtils.queryMap(userId)).execute()
        if (response.isSuccessful)
            userPhotos(response.body()?.photos?.photo as List<PhotoItem>)
        else
            Log.d(ProgramUtils.TAG, "${response.code()}")
    }

    private fun userPhotos(list: List<PhotoItem>) {
        listOfPhotoItem = list as MutableList<PhotoItem>
    }

    fun getUserPhoto():List<PhotoItem>{
        return listOfPhotoItem
    }

    fun setRetrofit(retrofit: Retrofit){
        PostInfoRepository.retrofit =retrofit
    }
}