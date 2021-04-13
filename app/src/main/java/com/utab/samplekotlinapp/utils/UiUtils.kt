package com.utab.samplekotlinapp.utils

import android.content.Context
import android.widget.Toast

class UiUtils {
    companion object{
        fun showToast(context: Context,msg:String)=
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}