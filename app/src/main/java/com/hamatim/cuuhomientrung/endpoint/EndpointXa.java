package com.hamatim.cuuhomientrung.endpoint;

import com.hamatim.cuuhomientrung.model.Xa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface EndpointXa {

    @GET("xa/")
    @Headers({"Content-Type: application/json"})
    Call<List<Xa>> all();

    @GET("xa/{id}")
    @Headers({"Content-Type: application/json"})
    Call<Xa> get(int id);

    @POST("xa")
    @Headers({"Content-Type: application/json"})
    Call<Xa> create(@Body Xa model);

    @PATCH("xa/{id}")
    @Headers({"Content-Type: application/json"})
    Call<Xa> update(int id, @Body Xa model);

    @DELETE("xa/{id}")
    @Headers({"Content-Type: application/json"})
    Call<Xa> delete(int id);

}
