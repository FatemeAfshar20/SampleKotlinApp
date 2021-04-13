package com.utab.samplekotlinapp.helper

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingHelper {

    companion object {
        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(imageView: ImageView, url: String) =
            Glide.with(imageView).load(url).centerCrop().into(imageView)
    }
}