package com.foysal.practice.hrmfinal.authorize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.foysal.practice.hrmfinal.R
import com.foysal.practice.hrmfinal.databinding.FragmentLoginBinding


class AuthorizeFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_authorize, container, false
        )
    return binding.root
    }

}