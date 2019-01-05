package me.darshpratap.coaster.api;

import me.darshpratap.coaster.models.api.Response;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PageIngsightApi {
    @GET("/insights")
    Call<Response> getResponse();
}
