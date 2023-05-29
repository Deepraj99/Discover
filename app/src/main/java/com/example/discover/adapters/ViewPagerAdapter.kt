package com.example.discover.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.discover.R
import com.example.discover.models.Article

class ViewPagerAdapter(private val newsList: List<Article>) : RecyclerView.Adapter<ViewPagerAdapter.MyViewHolder>() {
    private lateinit var view: View

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDemo = view.findViewById<TextView>(R.id.tv_demo)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_top_headlines, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvDemo.text = newsList[position].author
    }
}