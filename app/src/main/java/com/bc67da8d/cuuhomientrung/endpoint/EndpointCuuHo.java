package com.bc67da8d.cuuhomientrung.endpoint;

import com.bc67da8d.cuuhomientrung.model.CuuHo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface EndpointCuuHo {

    @GET("cuuho")
    @Headers({"Content-Type: application/json"})
    Call<List<CuuHo>> all();

    @GET("cuuho/{id}")
    @Headers({"Content-Type: application/json"})
    Call<CuuHo> get(int id);

    @POST("cuuho")
    @Headers({"Content-Type: application/json"})
    Call<CuuHo> create(@Body CuuHo model);

    @PATCH("cuuho/{id}")
    @Headers({"Content-Type: application/json"})
    Call<CuuHo> update(int id, @Body CuuHo model);

    @DELETE("cuuho/{id}")
    @Headers({"Content-Type: application/json"})
    Call<CuuHo> delete(int id);

}
