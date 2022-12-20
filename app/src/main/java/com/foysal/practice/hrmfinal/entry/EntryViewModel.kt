package com.foysal.practice.hrmfinal.entry

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.foysal.practice.hrmfinal.database.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class EntryViewModel(private val userId:String, val database : UserDatabase, application: Application)
    : AndroidViewModel(application), Observable{

    private var viewModelJob = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    @Bindable
    val userName = MutableLiveData<String>()

    @Bindable
    val userIdET = MutableLiveData<String>()

    @Bindable
    val userDate = MutableLiveData<String>()

    @Bindable
    val userType = MutableLiveData<String>()

    @Bindable
    val userException = MutableLiveData<String>()

    fun apply(){

    }

















    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}