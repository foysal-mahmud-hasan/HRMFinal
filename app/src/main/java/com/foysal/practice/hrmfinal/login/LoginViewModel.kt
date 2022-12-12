package com.foysal.practice.hrmfinal.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.foysal.practice.hrmfinal.database.UserDao
import kotlinx.coroutines.CoroutineScope

class LoginViewModel (
    val database: UserDao,
    application: Application,
    scope: CoroutineScope
        ) : AndroidViewModel(application){
}