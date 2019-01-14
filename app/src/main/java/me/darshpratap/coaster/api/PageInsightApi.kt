package me.darshpratap.coaster.api

import me.darshpratap.coaster.models.api.ResponsePojo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PageInsightApi {
    @GET("/insights")
    fun getResponse(@Query("url") url: String, @Query("strategy") strategy: String): Call<ResponsePojo>
}