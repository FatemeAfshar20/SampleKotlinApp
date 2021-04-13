package com.utab.samplekotlinapp.view.loginFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.utab.samplekotlinapp.R
import com.utab.samplekotlinapp.databinding.FragmentLoginBinding
import com.utab.samplekotlinapp.repository.UserRepository
import com.utab.samplekotlinapp.utils.UiUtils
import com.utab.samplekotlinapp.view.mainActivity.MainActivity

class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding
    private lateinit var vm:LoginVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm= LoginVm(UserRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        binding.viewModel=vm
        binding.fragment=this
        return binding.root
    }

    fun onLoginBtnClickListener(){
        if (vm.checkInputInfo()){
            activity?.let { UiUtils.showToast(it,"You Login successfully") }
            (activity as MainActivity).onSelectUserFragmentShow()
        }else
            activity?.let { UiUtils.showToast(it,"User name or password is wrong") }
    }

    fun onSignupBtnClickListener(){
        (activity as MainActivity).onSignFragmentShow()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}