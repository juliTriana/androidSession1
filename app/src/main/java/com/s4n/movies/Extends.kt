package com.s4n.movies

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(message:String)
{
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()

}