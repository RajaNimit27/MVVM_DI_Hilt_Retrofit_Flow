package com.app.mvvmhiltretrofitflow.data.remote

import com.app.mvvmhiltretrofitflow.data.ApiResponseData
import com.app.mvvmhiltretrofitflow.data.Post
import com.app.mvvmhiltretrofitflow.utils.Constants
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.H6)
    suspend fun getProducts(@Body jsonObject: JsonObject): Response<ApiResponseData>

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}