package com.app.mvvmhiltretrofitflow.data

data class ApiResponseData(
    var Message: String? = null,
    var ErrorCode: String? = null,
    var Data: DataModel? = null)

data class DataModel(
    var marketList: List<Product> = arrayListOf()
)

data class Product(
    var imgUrl: String? = null,
    var productId: Int? = null,
    var localPrice: Double? = null,
    var name: String? = null,
    var rank: Float? = null,
)


