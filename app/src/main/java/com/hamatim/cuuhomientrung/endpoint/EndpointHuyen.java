package com.hamatim.cuuhomientrung.endpoint;

import com.hamatim.cuuhomientrung.model.Huyen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface EndpointHuyen {

    @GET("huyen/")
    @Headers({"Content-Type: application/json"})
    Call<List<Huyen>> all();

    @GET("huyen/{id}")
    @Headers({"Content-Type: application/json"})
    Call<Huyen> get(int id);

    @POST("huyen")
    @Headers({"Content-Type: application/json"})
    Call<Huyen> create(@Body Huyen model);

    @PATCH("huyen/{id}")
    @Headers({"Content-Type: application/json"})
    Call<Huyen> update(int id, @Body Huyen model);

    @DELETE("huyen/{id}")
    @Headers({"Content-Type: application/json"})
    Call<Huyen> delete(int id);

}
