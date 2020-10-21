package com.hamatim.cuuhomientrung.endpoint;

import com.hamatim.cuuhomientrung.model.TinhNguyenVien;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface EndpointTinhNguyenVien {

    @GET("tinhnguyenvien/")
    @Headers({"Content-Type: application/json"})
    Call<List<TinhNguyenVien>> all();

    @GET("tinhnguyenvien/{id}")
    @Headers({"Content-Type: application/json"})
    Call<TinhNguyenVien> get(int id);

    @POST("tinhnguyenvien")
    @Headers({"Content-Type: application/json"})
    Call<TinhNguyenVien> create(@Body TinhNguyenVien model);

    @PATCH("tinhnguyenvien/{id}")
    @Headers({"Content-Type: application/json"})
    Call<TinhNguyenVien> update(int id, @Body TinhNguyenVien model);

    @DELETE("tinhnguyenvien/{id}")
    @Headers({"Content-Type: application/json"})
    Call<TinhNguyenVien> delete(int id);

}
