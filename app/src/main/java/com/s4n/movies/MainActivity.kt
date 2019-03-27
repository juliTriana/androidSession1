package com.s4n.movies

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  val  listData:MutableList<Movie> = arrayListOf()
    private  val adapter=MovieAdapter(this)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==CodesToResultIntent.ADD_MOVIE&& resultCode== Activity.RESULT_OK)
        {
            val extra =data?.extras

            extra?.let {
                listData.add(Movie(year =it.getInt("year") ,name = it.getString("name")))
                adapter.items=listData
            }


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cta.setOnClickListener{
            val intent=Intent(this,AddMovieActivity::class.java)
            startActivityForResult(intent,CodesToResultIntent.ADD_MOVIE)
        }

        list.layoutManager=GridLayoutManager(
            this,
            1,
            RecyclerView.VERTICAL,
            false
        )

        list.adapter=adapter

    }
}
