package com.utab.samplekotlinapp.view.splashFragment

import com.utab.samplekotlinapp.network.RetrofitInstance
import com.utab.samplekotlinapp.repository.PostInfoRepository

class SplashVM () {

     init {
         PostInfoRepository.setRetrofit(RetrofitInstance.getRetrofit())
     }

     public fun getRepository(): PostInfoRepository {
          return PostInfoRepository
     }
}