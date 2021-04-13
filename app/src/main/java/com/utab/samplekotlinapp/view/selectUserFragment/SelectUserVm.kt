package com.utab.samplekotlinapp.view.selectUserFragment

import androidx.lifecycle.ViewModel
import com.utab.samplekotlinapp.data.PhotoItem
import com.utab.samplekotlinapp.repository.PostInfoRepository
import com.utab.samplekotlinapp.repository.UserRepository

class SelectUserVm(private val repository:PostInfoRepository,private val userRepository:UserRepository):ViewModel() {
    private var markedList= mutableListOf<PhotoItem>()

    fun onUserOneBtnClickListener(){
        markedList=repository.userOneImages
    }

    fun onUserTwoBtnClickListener(){
        markedList=repository.userTwoImages
    }

    fun onUserThreeBtnClickListener(){
        markedList=repository.userThreeImages
    }

    fun onUserFourBtnClickListener(){
        markedList=repository.userFourImages
    }

    fun onUserFiveBtnClickListener(){
        markedList=repository.userFiveImages
    }

    fun userName():String=userRepository.getUser().userName

    fun getMarkedList():List<PhotoItem>{
        return markedList
    }
}