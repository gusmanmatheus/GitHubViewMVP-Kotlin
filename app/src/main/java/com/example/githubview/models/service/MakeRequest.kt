package com.example.githubview.models.service

import com.example.githubview.models.Repository
import com.example.githubview.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class MakeRequest(){
    fun getUsers(
        userName:String,
        sucess: (user:User) -> Unit,
        failure:(error:String) -> Unit
    ){
        val call = ServiceProvider().serviceData().userData(userName)
        call.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
            failure(t.message.toString())
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let(sucess)
            }

        })
    }

    fun getRepository(
        userName: String,
        sucess: (List<Repository>) -> Unit,
        failure: (String) -> Unit
    ){
        val call =ServiceProvider().serviceData().repositoryData(userName)
        call.enqueue(object : Callback<List<Repository>>{
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                failure(t.message.toString())
            }

            override fun onResponse(call: Call<List<Repository>>, response: Response<List<Repository>>) {
            response.body()?.let{

                    response.body()?.let(sucess)
            }
                if(response.isSuccessful){}else{sucess(emptyList())}
            }

        })

    }
}