package com.example.githubview.models

import android.os.Parcelable
import java.io.Serializable

data class Repository(val id:Long ,val name:String,val language:String):Serializable {

}