package com.app.mvvmhiltretrofitflow.data

import android.content.Context
import com.app.mvvmhiltretrofitflow.data.remote.RemoteDataSource
import com.app.mvvmhiltretrofitflow.data.remote.toResultFlow
import com.app.mvvmhiltretrofitflow.utils.NetWorkResult
import com.google.gson.JsonObject
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getProductList(context: Context, jsonObject: JsonObject): Flow<NetWorkResult<ApiResponseData>> {
        return toResultFlow(context){
            remoteDataSource.getProducts(jsonObject)
        }
    }

    suspend fun getPostList(context: Context): Flow<NetWorkResult<List<Post>>> {
        return toResultFlow(context){
            remoteDataSource.getPosts()
        }
    }

}