package com.example.githubview.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(val id:Long,val name:String,@SerializedName("avatar_url") val image: String): Serializable {
}