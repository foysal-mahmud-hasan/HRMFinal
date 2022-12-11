package com.foysal.practice.hrmfinal.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface UserDao {

    @Insert
    fun insert(userData : UserData)

    @Update
    fun update(userData: UserData)

    @Query("SELECT * FROM user_table")
    fun getAllUser() : LiveData<List<UserData>>


}