package com.app.mvvmhiltretrofitflow.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.mvvmhiltretrofitflow.data.ApiResponseData
import com.app.mvvmhiltretrofitflow.data.Post
import com.app.mvvmhiltretrofitflow.data.Repository
import com.app.mvvmhiltretrofitflow.utils.NetWorkResult
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository, application: Application): BaseViewModel(application) {
    private val _response: MutableLiveData<NetWorkResult<ApiResponseData>> = MutableLiveData()
    val response: LiveData<NetWorkResult<ApiResponseData>> = _response

    private val _responseposts: MutableLiveData<NetWorkResult<List<Post>>> = MutableLiveData()
    val responseposts: LiveData<NetWorkResult<List<Post>>> = _responseposts

    fun getProductsList(jsonObject: JsonObject) = viewModelScope.launch {
        repository.getProductList(context, jsonObject).collect { values ->
            _response.value = values
        }
    }

    fun getPostsList() = viewModelScope.launch {
        repository.getPostList(context).collect { values ->
            _responseposts.value = values
        }
    }
}