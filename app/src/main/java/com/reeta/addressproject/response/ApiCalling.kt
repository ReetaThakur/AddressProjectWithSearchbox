package com.reeta.addressproject.response

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalling {
    @GET("compassLocation/rest/address/autocomplete")

    suspend  fun getInstance(@Query("queryString") queryString:String,
    @Query("city")city:String,
    @Query("page") page:Int):ResponseDTO
}