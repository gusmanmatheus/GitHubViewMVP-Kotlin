package com.example.githubview.presenters

import com.example.githubview.models.Repository
import com.example.githubview.models.service.MakeRequest
import com.example.githubview.task.SearchUser

class PresenterSearchUser(val view: SearchUser.view) : SearchUser.presenter {


    override fun checkUserName(userName:String) {
        view.progressBarOn()
        if(userName.isEmpty()){
            view.alertEmptyText()
            view.progressBarOff()
        }
        else{
           view.callRequest(userName)
            view.progressBarOn()
        }
    }


    override  fun requestUser (userName: String){
        MakeRequest().getUsers(
            userName,
            fun(user):Unit {
             view.catchUser(user)

            },
            fun(error:String):Unit{
            view.errorCatch(error)
            })

    }

    override fun requstRepository(userName: String) {
        MakeRequest().getRepository(
            userName,fun(listRepository:List<Repository>):Unit {
             view.catchRepository(listRepository)
              view.resultRequest()
            },
            fun(error:String):Unit{
                view.errorCatch(error)
            })
    }

}