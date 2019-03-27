package com.s4n.movies

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        addMovie.setOnClickListener{
            val intent =Intent()
            intent.apply {
                putExtra("name",name.text.toString())
                putExtra("year",year.text.toString().toInt())
            }
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }
}
