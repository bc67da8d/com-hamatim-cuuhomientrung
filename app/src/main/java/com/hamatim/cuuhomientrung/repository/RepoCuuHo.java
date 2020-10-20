package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.callback.LamdaNetCallback;
import com.hamatim.cuuhomientrung.endpoint.EndpointCuuHo;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.provider.ProviderAPI;

import java.util.List;

public class RepoCuuHo implements IRepoCuuHo {

    @Override
    public void all(CallBack<List<CuuHo>> callBack) {
        new Thread(() ->
                ProviderAPI.get(EndpointCuuHo.class)
                        .all()
                        .enqueue(new LamdaNetCallback<>(
                                response -> callBack.callback(response.body()),
                                error -> {}
                        ))
        ).start();
    }

}
