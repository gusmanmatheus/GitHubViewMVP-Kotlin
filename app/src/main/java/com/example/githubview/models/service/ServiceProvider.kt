package com.example.githubview.models.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class ServiceProvider {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun serviceData() = retrofit.create(ApiService::class.java)
}