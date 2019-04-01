package com.example.githubview.presenters

import android.view.View
import com.example.githubview.task.PersonData

class PresenterPersonData(val view: PersonData.view):PersonData.presenter {

    override fun callData() {
        view.loadData()
    }
}