package com.example.androiduserexcercise.model

import com.google.gson.annotations.SerializedName

data class DataModel(

	@SerializedName("id")
	val id: Int,
	@SerializedName("first_name")
	val first_Name: String,
	@SerializedName("last_name")
	val last_Name: String,
	@SerializedName("email")
	val email: String,
	@SerializedName("avatar")
	val avatar: String


)
