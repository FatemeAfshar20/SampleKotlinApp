package com.utab.samplekotlinapp.view.splashFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.utab.samplekotlinapp.R
import com.utab.samplekotlinapp.data.PhotoItem
import com.utab.samplekotlinapp.databinding.FragmentSplashBinding
import com.utab.samplekotlinapp.utils.NetworkUtils
import com.utab.samplekotlinapp.view.mainActivity.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {
    lateinit var splashVM:  SplashVM
    lateinit var binding:FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashVM= SplashVM()
       GlobalScope.launch {
           splashVM.getRepository().requestServerReceivePosts(NetworkUtils.USER_ID_ONE)
           splashVM.getRepository().userOneImages= splashVM.getRepository().getUserPhoto() as MutableList<PhotoItem>

           splashVM.getRepository().requestServerReceivePosts(NetworkUtils.USER_ID_TWO)
           splashVM.getRepository().userTwoImages= splashVM.getRepository().getUserPhoto() as MutableList<PhotoItem>

           splashVM.getRepository().requestServerReceivePosts(NetworkUtils.USER_ID_THREE)
           splashVM.getRepository().userThreeImages= splashVM.getRepository().getUserPhoto() as MutableList<PhotoItem>

           splashVM.getRepository().requestServerReceivePosts(NetworkUtils.USER_ID_FOUR)
           splashVM.getRepository().userFourImages= splashVM.getRepository().getUserPhoto() as MutableList<PhotoItem>

           splashVM.getRepository().requestServerReceivePosts(NetworkUtils.USER_ID_FIVE)
           splashVM.getRepository().userFiveImages= splashVM.getRepository().getUserPhoto() as MutableList<PhotoItem>

           (activity as MainActivity).onLoginFragmentShow()
       }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_splash,container,false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(): SplashFragment {
            val bundle = Bundle()
            return SplashFragment().apply {
                arguments = bundle
            }
        }
    }
}