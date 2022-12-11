package com.foysal.practice.hrmfinal.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exception_table")
data class ExceptionData (

    @PrimaryKey(autoGenerate = true)
    var exceptionId : Int = 0,

    @ColumnInfo(name = "userException")
    var userException : String,

    @ColumnInfo(name = "userDate")
    var userDate : String,

    @ColumnInfo(name = "userRemark")
    var userRemark : String,

    @ColumnInfo(name = "userStatus")
    var userStatus : String,

    @ColumnInfo(name = "userExceptionId")
    var userExceptionId : Int

)