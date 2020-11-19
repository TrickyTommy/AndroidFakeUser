package com.example.androiduserexcercise.model

import com.google.gson.annotations.SerializedName

data class ResponseData(

	@field:SerializedName("per_page")
	val perPage: Int,
	@field:SerializedName("total")
	val total: Int,
	@field:SerializedName("data")
	val data: List<DataModel>,
	@field:SerializedName("page")
	val page: Int,
	@field:SerializedName("total_pages")
	val totalPages: Int
)

