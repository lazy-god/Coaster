package me.darshpratap.coaster.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object PageInsightService {
    private var api: PageInsightApi? = null

    fun getInsightApi(): PageInsightApi? {
        if (api == null) {
            val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .build()

            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("https://coaster-backend.appspot.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

            api = retrofit.create(PageInsightApi::class.java)
        }
        return api
    }
}