package com.foysal.practice.hrmfinal.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.foysal.practice.hrmfinal.database.UserDao
import com.foysal.practice.hrmfinal.database.UserDatabase
import kotlinx.coroutines.*

class LoginViewModel (
    val database: UserDao,
    application: Application) : AndroidViewModel(application){

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope( Dispatchers.Main + viewModelJob)

    private var _passState = MutableLiveData<Boolean>()
    val passSate: LiveData<Boolean>
        get() = _passState
    fun passStateValidated() {
        _passState.postValue(true)
    }
    fun navigateToHome(){
        _passState.postValue(false)
    }
//    fun loginPressed(
//        id: String,
//        password: String,
//        uiScope: CoroutineScope,
//        dataSource: UserDatabase
//    ){
//
//        uiScope.launch {
//
//            validate(id, password)
//
//        }
//    }
//    suspend fun validate(id : String, password: String){
//
//        withContext(Dispatchers.IO){
//
//            val user = database.validate(id, password)
//
//            if (user != null){
//                passStateValidated()
//            }else
//                navigateToHome()
//        }
//
//    }
    override fun onCleared(){

        super.onCleared()
        viewModelJob.cancel()

    }
}