package me.darshpratap.coaster.api;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PageInsightService {
    private PageInsightService() {}
    private static PageIngsightApi api = null;

    public static PageIngsightApi getInsightApi() {
        if (api == null)  {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.7:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

            api = retrofit.create(PageIngsightApi.class);
        }
        Log.d("fuck", "error" + api);
        return api;
    }
}
