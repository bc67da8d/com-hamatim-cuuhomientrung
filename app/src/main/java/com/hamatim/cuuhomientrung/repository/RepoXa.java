package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.callback.LamdaNetCallback;
import com.hamatim.cuuhomientrung.endpoint.EndpointTinh;
import com.hamatim.cuuhomientrung.endpoint.EndpointXa;
import com.hamatim.cuuhomientrung.model.Tinh;
import com.hamatim.cuuhomientrung.model.Xa;
import com.hamatim.cuuhomientrung.provider.ProviderAPI;

import java.util.List;

public class RepoXa implements IRepoXa {

    @Override
    public void all(CallBack<List<Xa>> callBack) {
        new Thread(() ->
                ProviderAPI.get(EndpointXa.class)
                        .all()
                        .enqueue(new LamdaNetCallback<>(
                                response -> callBack.callback(response.body()),
                                error -> {}
                        ))
        ).start();
    }

}
