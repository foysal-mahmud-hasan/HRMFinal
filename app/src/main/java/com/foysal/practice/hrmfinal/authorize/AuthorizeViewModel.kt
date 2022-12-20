package com.foysal.practice.hrmfinal.authorize

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.foysal.practice.hrmfinal.database.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class AuthorizeViewModel (private val userId : String, val database: UserDatabase, application: Application)
    : AndroidViewModel(application){

    private var viewModelJob = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

}