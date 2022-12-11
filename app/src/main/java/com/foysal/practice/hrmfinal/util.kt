package com.foysal.practice.hrmfinal

import android.content.res.Resources
import android.text.Spanned
import com.foysal.practice.hrmfinal.database.ExceptionData

fun allExceptions(exceptions : List<ExceptionData>, resources: Resources): Spanned{

    val sb = StringBuilder()

    sb.apply {
        append("<br>")
        append(resources.getString(R.string.title))

    }

}