package com.bc67da8d.cuuhomientrung.repository;

import com.bc67da8d.cuuhomientrung.callback.CallBack;
import com.bc67da8d.cuuhomientrung.callback.LamdaNetCallback;
import com.bc67da8d.cuuhomientrung.endpoint.EndpointCuuHo;
import com.bc67da8d.cuuhomientrung.endpoint.EndpointTinhNguyenVien;
import com.bc67da8d.cuuhomientrung.model.CuuHo;
import com.bc67da8d.cuuhomientrung.provider.ProviderAPI;

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
