package com.hamatim.cuuhomientrung.endpoint;

import com.hamatim.cuuhomientrung.model.CuuHo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EndpointCuuHo {

    @GET("cuuho/")
    @Headers({"Content-Type: application/json"})
    Call<List<CuuHo>> all();

    @GET("cuuho/{id}/")
    @Headers({"Content-Type: application/json"})
    Call<CuuHo> get(@Path("id") int id);

    @POST("cuuho/")
    @Headers({"Content-Type: application/json"})
    Call<CuuHo> create(@Body CuuHo model);

    @PATCH("cuuho/{id}/")
    @Headers({"Content-Type: application/json"})
    Call<CuuHo> update(@Path("id") int id, @Body CuuHo model);

    @DELETE("cuuho/{id}/")
    @Headers({"Content-Type: application/json"})
    Call<CuuHo> delete(@Path("id") int id);

}
