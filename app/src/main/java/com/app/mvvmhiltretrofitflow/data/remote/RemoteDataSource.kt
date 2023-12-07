package com.app.mvvmhiltretrofitflow.data.remote

import com.google.gson.JsonObject
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getProducts(jsonObject: JsonObject) = apiService.getProducts(jsonObject)
    suspend fun getPosts() = apiService.getPosts()
}