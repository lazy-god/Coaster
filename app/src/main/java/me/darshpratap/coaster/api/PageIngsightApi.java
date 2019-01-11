package me.darshpratap.coaster.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PageIngsightApi {
    @GET("/insights")
    Call<ResponseApi> getResponse();
}
