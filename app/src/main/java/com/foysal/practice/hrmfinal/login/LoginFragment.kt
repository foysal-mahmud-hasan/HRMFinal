package com.foysal.practice.hrmfinal.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.foysal.practice.hrmfinal.R
import com.foysal.practice.hrmfinal.database.UserDatabase
import com.foysal.practice.hrmfinal.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding : FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login,container, false)

        val application = requireNotNull(this.activity).application
        val scope = CoroutineScope(Dispatchers.Main)
        val dataSource = UserDatabase.getInstance(application, scope).userDao

        val viewModelFactory = LoginViewModelFactory(dataSource, application, scope)

        val loginViewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]

        binding.loginViewModel = loginViewModel

        binding.lifecycleOwner = this



        return binding.root
    }

}