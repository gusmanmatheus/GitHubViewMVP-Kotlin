package com.example.githubview.task

import com.example.githubview.models.Repository

interface PersonData {
    interface view{
    fun loadData()
    fun fillRecycleView(list :List<Repository>)
    fun fillUserData()

    }
    interface presenter{
        fun callData()
    }
}