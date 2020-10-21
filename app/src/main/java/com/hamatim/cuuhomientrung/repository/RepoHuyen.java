package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.callback.LamdaNetCallback;
import com.hamatim.cuuhomientrung.endpoint.EndpointHuyen;
import com.hamatim.cuuhomientrung.endpoint.EndpointTinh;
import com.hamatim.cuuhomientrung.model.Huyen;
import com.hamatim.cuuhomientrung.model.Tinh;
import com.hamatim.cuuhomientrung.provider.ProviderAPI;

import java.util.List;

public class RepoHuyen implements IRepoHuyen{

    @Override
    public void all(CallBack<List<Huyen>> callBack) {
        new Thread(() ->
                ProviderAPI.get(EndpointHuyen.class)
                        .all()
                        .enqueue(new LamdaNetCallback<>(
                                response -> callBack.callback(response.body()),
                                error -> {}
                        ))
        ).start();
    }

}
