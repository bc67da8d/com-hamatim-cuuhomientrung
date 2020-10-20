package com.bc67da8d.cuuhomientrung.endpoint;

import com.bc67da8d.cuuhomientrung.model.CuuHo;
import com.bc67da8d.cuuhomientrung.model.HoDan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface EndpointHoDan {

    @GET("hodan")
    @Headers({"Content-Type: application/json"})
    Call<List<HoDan>> all();

    @GET("hodan/{id}")
    @Headers({"Content-Type: application/json"})
    Call<HoDan> get(int id);

    @POST("hodan")
    @Headers({"Content-Type: application/json"})
    Call<HoDan> create(@Body HoDan model);

    @PATCH("hodan/{id}")
    @Headers({"Content-Type: application/json"})
    Call<HoDan> update(int id, @Body HoDan model);

    @DELETE("hodan/{id}")
    @Headers({"Content-Type: application/json"})
    Call<HoDan> delete(int id);

}
