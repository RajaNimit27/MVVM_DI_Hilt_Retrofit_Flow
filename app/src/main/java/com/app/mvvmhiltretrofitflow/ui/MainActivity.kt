package com.app.mvvmhiltretrofitflow.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.mvvmhiltretrofitflow.R
import com.app.mvvmhiltretrofitflow.data.ApiResponseData
import com.app.mvvmhiltretrofitflow.data.ApiResultHandler
import com.app.mvvmhiltretrofitflow.databinding.ActivityMainBinding
import com.app.mvvmhiltretrofitflow.databinding.ActivityProductListBinding
import com.app.mvvmhiltretrofitflow.viewmodels.MainViewModel
import com.google.gson.JsonObject
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        activityMainBinding.activity= this@MainActivity
    }

   fun onClickButton(isPostMethod:Boolean){
       try {
           if(isPostMethod){
               startActivity(Intent(this@MainActivity,ProductListActivity::class.java))
           }else{
               startActivity(Intent(this@MainActivity,PostListActivity::class.java))
           }
       }catch (e:Exception){
           e.stackTrace
       }
   }


}