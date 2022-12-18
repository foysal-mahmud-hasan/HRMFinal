package com.foysal.practice.hrmfinal.home

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.foysal.practice.hrmfinal.database.UserDatabase
import kotlinx.coroutines.*

class HomeViewModel(private val userId: String, role : String,
                    val database: UserDatabase) : ViewModel() {


    init {
        getUserRole()
    }
    private var viewModelJob = Job()
    val scope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToExceptionEntry = MutableLiveData<Boolean>()
    val navigateToExceptionEntry : LiveData<Boolean>
        get() = _navigateToExceptionEntry

    private val _navigateToAuthorize = MutableLiveData<Boolean>()
    val navigateToAuthorize : LiveData<Boolean>
        get() = _navigateToAuthorize

    private val _userRole = MutableLiveData<String>()
    val userRole : LiveData<String>
        get() = _userRole

    private val admin = MutableLiveData<Boolean>()
    private val employee = MutableLiveData<Boolean>()

    private fun getUserRole(){
        scope.launch {
            _userRole.value = database.userDao.role(userId)
            if (_userRole.value == "admin"){
                admin.value = true
                employee.value = true
            } else{
                admin.value = false
                employee.value = true
            }
        }
    }

    fun exceptionEntry(){



    }
    @BindingAdapter("android:visibility")
    fun exceptionEntryVisible(view: View){
        view.visibility = if (userRole.value=="admin") View.VISIBLE else View.INVISIBLE
    }
    @BindingAdapter("android:visibility")
    fun authorizeVisible(view : View) {
    }






    fun authorize(){



    }
    fun findRole(id : String){

        scope.launch {
            withContext(Dispatchers.IO){

                _userRole.value = database.userDao.role(id)

            }
        }

    }


    override fun onCleared(){

        super.onCleared()
        viewModelJob.cancel()

    }
}