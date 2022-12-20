package com.foysal.practice.hrmfinal.authorize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.foysal.practice.hrmfinal.R
import com.foysal.practice.hrmfinal.database.UserDatabase
import com.foysal.practice.hrmfinal.databinding.FragmentAuthorizeBinding
import com.foysal.practice.hrmfinal.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class AuthorizeFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: FragmentAuthorizeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_authorize, container, false)

        val arguments = AuthorizeFragmentArgs.fromBundle(requireArguments())
        val application = requireNotNull(this.activity).application
        val scope = CoroutineScope(Dispatchers.Main)
        val dataSource = UserDatabase.getInstance(application, scope)

        val viewModelFactory = AuthorizeViewModelFactory(arguments.id, dataSource, application)
        val authorizeViewModel = ViewModelProvider(this, viewModelFactory).get(AuthorizeViewModel::class.java)

    return binding.root
    }

}