package com.utab.samplekotlinapp.view.selectUserFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.utab.samplekotlinapp.R
import com.utab.samplekotlinapp.databinding.FragmentSelectUserBinding
import com.utab.samplekotlinapp.repository.PostInfoRepository
import com.utab.samplekotlinapp.view.mainActivity.MainActivity

class SelectUserFragment : Fragment() {
    private lateinit var binding:FragmentSelectUserBinding
    private lateinit var vm: SelectUserVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm= activity?.let { ViewModelProvider(it,SelectUserViewModelProvider()).get(SelectUserVm::class.java) }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_select_user,container,false)
        binding.viewModel=vm
        binding.fragment=this
        return binding.root
    }

    fun onBtnClickListener(){
        (activity as MainActivity).onPhotosFragmentShow()
    }

    companion object {
        @JvmStatic
        fun newInstance(): SelectUserFragment = SelectUserFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}