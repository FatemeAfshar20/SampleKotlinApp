package com.utab.samplekotlinapp.view.selectUserFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.utab.samplekotlinapp.repository.PostInfoRepository
import com.utab.samplekotlinapp.repository.UserRepository

class SelectUserViewModelProvider : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SelectUserVm(PostInfoRepository,UserRepository) as T
    }
}