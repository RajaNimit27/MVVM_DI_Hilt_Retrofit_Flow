package com.app.mvvmhiltretrofitflow.data

import android.content.Context
import com.app.mvvmhiltretrofitflow.utils.ApiStatus
import com.app.mvvmhiltretrofitflow.utils.Constants.Companion.API_FAILURE_CODE
import com.app.mvvmhiltretrofitflow.utils.Constants.Companion.API_INTERNET_CODE
import com.app.mvvmhiltretrofitflow.utils.Constants.Companion.API_INTERNET_MESSAGE
import com.app.mvvmhiltretrofitflow.utils.Constants.Companion.API_SOMETHING_WENT_WRONG_MESSAGE
import com.app.mvvmhiltretrofitflow.utils.Constants.Companion.API_SUCCESS_CODE
import com.app.mvvmhiltretrofitflow.utils.NetWorkResult
import com.app.mvvmhiltretrofitflow.utils.Utils
import kotlin.reflect.full.memberProperties

class ApiResultHandler<T>(private val context: Context,  private val onLoading: () -> Unit, private val onSuccess: (T?) -> Unit, private val onFailure: (T?) -> Unit) {

    fun handleApiResult(result: NetWorkResult<T?>) {
        when (result.status) {
            ApiStatus.LOADING -> {
               onLoading()
            }
            ApiStatus.SUCCESS -> {
                onSuccess(result.data)
            }

            ApiStatus.ERROR -> {
                onFailure(result.data)
                when (result.data?.getField<String>("ErrorCode") ?: "0") {
                    API_FAILURE_CODE -> {
                        Utils.showAlertDialog(context, result.message.toString())
                    }
                    API_INTERNET_CODE -> {
                        //Show Internet Error
                        Utils.showAlertDialog(context, API_INTERNET_MESSAGE)
                    }
                    else -> {
                        //Something went wrong dialog
                        Utils.showAlertDialog(context, API_SOMETHING_WENT_WRONG_MESSAGE)
                    }
                }
            }
        }
    }

    @Throws(IllegalAccessException::class, ClassCastException::class)
    inline fun <reified T> Any.getField(fieldName: String): T? {
        this::class.memberProperties.forEach { kCallable ->
            if (fieldName == kCallable.name) {
                return kCallable.getter.call(this) as T?
            }
        }
        return null
    }

}
