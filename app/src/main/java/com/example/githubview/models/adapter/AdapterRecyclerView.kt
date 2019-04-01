package com.example.githubview.models.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.githubview.R
import com.example.githubview.models.Repository

class AdapterRecyclerView(val list : List<Repository>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(p0?.context)
        val cellForRow =layoutInflater.inflate(R.layout.itemlist,p0,false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.repositoryName.text = list[p1].name
        p0.repositorylanguage.text = list[p1].language
    }


}

class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    var repositoryName : TextView = itemView.findViewById(R.id.nameRepository)
    var repositorylanguage : TextView = itemView.findViewById(R.id.languageRepository)


}

