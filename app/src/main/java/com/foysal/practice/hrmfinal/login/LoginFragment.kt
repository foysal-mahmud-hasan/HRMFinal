package com.foysal.practice.hrmfinal.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.foysal.practice.hrmfinal.R
import com.foysal.practice.hrmfinal.database.UserDao
import com.foysal.practice.hrmfinal.database.UserData
import com.foysal.practice.hrmfinal.database.UserDatabase
import com.foysal.practice.hrmfinal.databinding.FragmentLoginBinding
import kotlinx.coroutines.*

class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding : FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login,container, false)

        val application = requireNotNull(this.activity).application
        val scope = CoroutineScope(Dispatchers.Main)
        val dataSource = UserDatabase.getInstance(application, scope)

        val viewModelFactory = LoginViewModelFactory(dataSource.userDao, application)

        val loginViewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]

        binding.loginViewModel = loginViewModel

        scope.launch{

            withContext(Dispatchers.IO){

                val user : UserData
                user.userId = "1"
                user.userRole = "admin"


            }

        }

//        val viewModelJob = Job()
//        val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
        binding.lifecycleOwner = this

        var id : String = binding.loginId.toString()
        var password : String = binding.loginPass.toString()
        binding.btnLogin.setOnClickListener{
            loginPressed(id, password, dataSource,scope)
        }

        return binding.root
    }
    private fun loginPressed(id: String, password: String, dataSource: UserDatabase, scope: CoroutineScope
    ){

        lifecycleScope.launch {

            withContext(Dispatchers.IO){

//                val user = dataSource.userDao.validate(id, password)
                val user = dataSource.userDao.getAllUser()
                Log.i("USER","${user.value?.size}")
                val user1 = dataSource.userDao.getAllUserList()
                Log.i("USER", "${user1.size}")


            }

        }
        }
}


