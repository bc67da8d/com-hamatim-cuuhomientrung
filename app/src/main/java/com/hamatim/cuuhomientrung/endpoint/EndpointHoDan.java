package com.hamatim.cuuhomientrung.endpoint;

import com.hamatim.cuuhomientrung.model.HoDan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EndpointHoDan {

    @GET("hodan/")
    @Headers({"Content-Type: application/json"})
    Call<List<HoDan>> all();

    @GET("hodan/{id}/")
    @Headers({"Content-Type: application/json"})
    Call<HoDan> get(@Path("id") int id);

    @POST("hodan/")
    @Headers({"Content-Type: application/json"})
    Call<HoDan> create(@Body HoDan model);

    @PATCH("hodan/{id}/")
    @Headers({"Content-Type: application/json"})
    Call<HoDan> update(@Path("id") int id, @Body HoDan model);

    @DELETE("hodan/{id}/")
    @Headers({"Content-Type: application/json"})
    Call<HoDan> delete(@Path("id") int id);

}
