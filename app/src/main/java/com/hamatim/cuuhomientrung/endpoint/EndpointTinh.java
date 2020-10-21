package com.hamatim.cuuhomientrung.endpoint;

import com.hamatim.cuuhomientrung.model.Tinh;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface EndpointTinh {

    @GET("tinh/")
    @Headers({"Content-Type: application/json"})
    Call<List<Tinh>> all();

    @GET("tinh/{id}")
    @Headers({"Content-Type: application/json"})
    Call<Tinh> get(int id);

    @POST("tinh")
    @Headers({"Content-Type: application/json"})
    Call<Tinh> create(@Body Tinh model);

    @PATCH("tinh/{id}")
    @Headers({"Content-Type: application/json"})
    Call<Tinh> update(int id, @Body Tinh model);

    @DELETE("tinh/{id}")
    @Headers({"Content-Type: application/json"})
    Call<Tinh> delete(int id);

}
