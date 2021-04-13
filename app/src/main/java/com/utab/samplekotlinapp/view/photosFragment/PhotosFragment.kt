package com.utab.samplekotlinapp.view.photosFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.utab.samplekotlinapp.R
import com.utab.samplekotlinapp.adapter.PhotoItemAdapter
import com.utab.samplekotlinapp.databinding.FragmentPhotosBinding
import com.utab.samplekotlinapp.view.selectUserFragment.SelectUserViewModelProvider
import com.utab.samplekotlinapp.view.selectUserFragment.SelectUserVm

class PhotosFragment : Fragment() {
    private lateinit var binding:FragmentPhotosBinding
    private lateinit var vm:SelectUserVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm= activity?.let { ViewModelProvider(it, SelectUserViewModelProvider()).get(SelectUserVm::class.java) }!!
        vm.getMarkedList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_photos,container,false)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        val adapter=PhotoItemAdapter(vm.getMarkedList())
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=GridLayoutManager(activity,2)
    }

    companion object{
        @JvmStatic
        fun newInstance():PhotosFragment=PhotosFragment().apply {
            arguments=Bundle().apply {

            }
        }
    }
}