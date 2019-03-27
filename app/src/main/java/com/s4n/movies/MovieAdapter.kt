package com.s4n.movies

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_item.view.*
import kotlin.properties.Delegates


class MovieAdapter(val context: Activity):RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

     var items:List<Movie> by Delegates.observable(arrayListOf()){_,_,_->
         notifyDataSetChanged()
     }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun getItemCount()= items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindModel(items[position])
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{


        override fun onClick(v: View?) {
          context.showToast(items[adapterPosition].name)
        }

        fun bindModel(item:Movie)
        {
            itemView.setOnClickListener(this)
            with(item)
            {
               itemView.apply {
                   nameTV.text=name
                   yearTV.text="${year.toString()} - Premiere"
               }
            }

        }
    }
}