package com.example.githubview.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import com.example.githubview.R
import com.example.githubview.models.ParseList
import com.example.githubview.models.Repository
import com.example.githubview.models.User
import com.example.githubview.presenters.PresenterSearchUser
import com.example.githubview.task.SearchUser
import kotlinx.android.synthetic.main.activity_searchuser.*

class SearchUserActivity : AppCompatActivity(),SearchUser.view {
    private var presenterSerachUser : SearchUser.presenter? = null
    private var fragmentLoading : FrameLayout? = null
    private var buttonSearch : Button? = null
    private var editUserName : EditText? = null
    private var userOfClass:User? = null
    private var listaRepositoryOfClass:List<Repository>?=null
    private var errorUser : String? = null
    private var errorRepository: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchuser)
        presenterSerachUser = PresenterSearchUser(this)
        fragmentLoading = fragmentLoading_Id
        buttonSearch = buttoSearch
        editUserName = EditUserName
        buttonSearch?.setOnClickListener( {
            presenterSerachUser?.checkUserName(editUserName?.text.toString())
        })
    }

    override fun progressBarOn() {
        fragmentLoading?.visibility = View.VISIBLE
    }

    override fun progressBarOff() {
        fragmentLoading?.visibility= View.GONE
    }


    override fun alertEmptyText(){
        Toast.makeText(this,"Texto Vazio, Coloque um Usuario",Toast.LENGTH_SHORT).show()
    }

    override fun callRequest(nomeUser: String) {
        presenterSerachUser?.requestUser(nomeUser)
        presenterSerachUser?.requstRepository(nomeUser)

    }
    //
    override fun resultRequest() {
        progressBarOff()
        if(userOfClass!=null&&listaRepositoryOfClass?.size!=0){
            nextActivity()
        }else{
            Toast.makeText(this, "nome de usuario errado",Toast.LENGTH_LONG).show()
        }
    }
        override fun catchUser(user: User) {
            userOfClass=user    }

        override fun catchRepository(list: List<Repository>) {
            listaRepositoryOfClass=list    }



    override fun nextActivity() {
        val  intent= Intent(this,PersonDataActivity::class.java)
        intent.putExtra("userData",userOfClass)
        intent.putExtra("listRepositoryData", ParseList(listaRepositoryOfClass))
        startActivity(intent)

    }
    override fun errorCatch(error: String) {
        Toast.makeText(this,"Algum erro inesperado verifique a internet",Toast.LENGTH_SHORT).show()
        progressBarOff()
    }

//override fun tes(){
//    Toast.makeText(this, "user errado",Toast.LENGTH_LONG).show()
//
//}
}
