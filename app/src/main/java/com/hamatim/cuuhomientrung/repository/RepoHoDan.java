package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.callback.LamdaNetCallback;
import com.hamatim.cuuhomientrung.endpoint.EndpointHoDan;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderAPI;

import java.util.List;

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
