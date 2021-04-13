package com.utab.samplekotlinapp.view.mainActivity

import androidx.fragment.app.Fragment
import com.utab.samplekotlinapp.R
import com.utab.samplekotlinapp.view.SingleFragmentActivity
import com.utab.samplekotlinapp.view.loginFragment.LoginFragment
import com.utab.samplekotlinapp.view.photosFragment.PhotosFragment
import com.utab.samplekotlinapp.view.selectUserFragment.SelectUserFragment
import com.utab.samplekotlinapp.view.signFragment.SignUpFragment
import com.utab.samplekotlinapp.view.splashFragment.SplashFragment

class MainActivity : SingleFragmentActivity() {
    override fun getFragment(): Fragment {
        return SplashFragment.newInstance()
    }

    fun onLoginFragmentShow() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LoginFragment.newInstance()).commit()
    }

    fun onSignFragmentShow() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SignUpFragment.newInstance())
            .addToBackStack(LoginFragment::class.java.simpleName).commit()
    }

    fun onSelectUserFragmentShow() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SelectUserFragment.newInstance())
            .commit()
    }

    fun onPhotosFragmentShow() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, PhotosFragment.newInstance())
            .addToBackStack(SelectUserFragment::class.java.simpleName)
            .commit()
    }
}