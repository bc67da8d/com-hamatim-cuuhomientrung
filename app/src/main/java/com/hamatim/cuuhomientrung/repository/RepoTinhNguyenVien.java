package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.callback.LamdaNetCallback;
import com.hamatim.cuuhomientrung.endpoint.EndpointTinhNguyenVien;
import com.hamatim.cuuhomientrung.model.TinhNguyenVien;
import com.hamatim.cuuhomientrung.provider.ProviderAPI;

import java.util.List;

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
