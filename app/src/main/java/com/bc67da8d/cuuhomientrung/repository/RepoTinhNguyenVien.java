package com.bc67da8d.cuuhomientrung.repository;

import com.bc67da8d.cuuhomientrung.callback.CallBack;
import com.bc67da8d.cuuhomientrung.callback.LamdaNetCallback;
import com.bc67da8d.cuuhomientrung.endpoint.EndpointTinhNguyenVien;
import com.bc67da8d.cuuhomientrung.model.TinhNguyenVien;
import com.bc67da8d.cuuhomientrung.provider.ProviderAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoTinhNguyenVien implements IRepoTinhNguyenVien {

    @Override
    public void all(CallBack<List<TinhNguyenVien>> callBack) {
        new Thread(() ->
                ProviderAPI.get(EndpointTinhNguyenVien.class)
                .all()
                .enqueue(new LamdaNetCallback<>(
                        response -> callBack.callback(response.body()),
                        error -> {}
                ))
        ).start();
    }

}
