package com.example.githubview.task

import com.example.githubview.models.Repository
import com.example.githubview.models.User

interface SearchUser {
    interface view{
        fun progressBarOn()
        fun progressBarOff()
        fun alertEmptyText()
        fun callRequest(nomeUser : String)
        fun nextActivity()
        fun catchUser(user: User)
        fun catchRepository(list : List<Repository>)
        fun errorCatch(error : String)
        fun resultRequest()
//        fun tes()


    }
    interface presenter{
        fun checkUserName(userName:String)
         fun requestUser(userName: String)
        fun requstRepository(userName: String)
    }
}