package com.s4n.movies

import android.content.Context
import android.widget.Toast

interface IAlert {
    val context:Context
    fun show(message:String)
    {
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }
}