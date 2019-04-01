package com.example.githubview.models.service

import com.example.githubview.models.Repository
import com.example.githubview.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{userName}")
    fun userData(@Path("userName")userName:String): Call<User>
    @GET("users/{userName}/repos")
    fun repositoryData(@Path("userName")userName:String): Call<List<Repository>>


}