package com.utab.samplekotlinapp.view.signFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.utab.samplekotlinapp.R
import com.utab.samplekotlinapp.databinding.FragmentSignUpBinding
import com.utab.samplekotlinapp.repository.UserRepository
import com.utab.samplekotlinapp.utils.UiUtils
import com.utab.samplekotlinapp.view.mainActivity.MainActivity

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var vm: SignUpVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = SignUpVM(UserRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        binding.viewModel = vm
        binding.fragment = this
        return binding.root
    }

    fun onSignBtnClickListener() {
        vm.onSignBtnClickListener()
        activity?.let { UiUtils.showToast(it, "You sign up successfully") }
        (activity as MainActivity).onLoginFragmentShow()
    }

    companion object {
        @JvmStatic
        fun newInstance(): SignUpFragment = SignUpFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}