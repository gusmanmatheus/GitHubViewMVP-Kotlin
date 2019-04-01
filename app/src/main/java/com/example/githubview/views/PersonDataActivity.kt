package com.example.githubview.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubview.R
import com.example.githubview.models.ParseList
import com.example.githubview.models.Repository
import com.example.githubview.models.User
import com.example.githubview.models.adapter.AdapterRecyclerView
import com.example.githubview.presenters.PresenterPersonData
import com.example.githubview.task.PersonData
import kotlinx.android.synthetic.main.activity_person_data.*

class PersonDataActivity : AppCompatActivity(),PersonData.view {


    private var user:User? = null
    private var listRepository:ParseList? = null
    private var presenterPersonData :PresenterPersonData?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_data)
        var toolbar = toolbarPersonActivty
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeButtonEnabled(true)
        getSupportActionBar()?.setTitle("")
        presenterPersonData = PresenterPersonData(this)
        presenterPersonData?.callData()
    }
    override fun loadData() {
        user = intent.getSerializableExtra("userData") as User?
        listRepository = intent.getSerializableExtra("listRepositoryData") as ParseList?
        var list:List<Repository> = listRepository?.listRepository as List<Repository>
       // fillRecycleView(list)
        fillUserData()


    }
    override fun fillUserData() {
    nameUser.text=this.user?.name
        Glide.with(this).load(user?.image).apply(RequestOptions.circleCropTransform()).into(imageUser)
        fillRecycleView(listRepository?.listRepository!!)
    }
    override fun fillRecycleView(list :List<Repository>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterRecyclerView(list)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.getItemId()) {
            android.R.id.home
            -> {
                onBackPressed()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
        return super.onOptionsItemSelected(item)
    }


}
