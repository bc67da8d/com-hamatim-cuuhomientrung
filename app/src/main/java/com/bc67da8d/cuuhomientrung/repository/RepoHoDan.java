package com.bc67da8d.cuuhomientrung.repository;

import com.bc67da8d.cuuhomientrung.callback.CallBack;
import com.bc67da8d.cuuhomientrung.callback.LamdaNetCallback;
import com.bc67da8d.cuuhomientrung.endpoint.EndpointHoDan;
import com.bc67da8d.cuuhomientrung.endpoint.EndpointTinhNguyenVien;
import com.bc67da8d.cuuhomientrung.model.HoDan;
import com.bc67da8d.cuuhomientrung.model.TinhNguyenVien;
import com.bc67da8d.cuuhomientrung.provider.ProviderAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoHoDan implements IRepoHoDan {

    @Override
    public void all(CallBack<List<HoDan>> callBack) {
        new Thread(() ->
                ProviderAPI.get(EndpointHoDan.class)
                        .all()
                        .enqueue(new LamdaNetCallback<>(
                                response -> callBack.callback(response.body()),
                                error -> {}
                        ))
        ).start();
    }

}
