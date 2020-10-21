package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.callback.LamdaNetCallback;
import com.hamatim.cuuhomientrung.endpoint.EndpointCuuHo;
import com.hamatim.cuuhomientrung.endpoint.EndpointHoDan;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.model.DTO;
import com.hamatim.cuuhomientrung.model.Event;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderAPI;
import com.hamatim.cuuhomientrung.util.Constant;

import java.io.IOException;
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

    @Override
    public void create(CallBack<DTO<CuuHo>> callBack, CuuHo model) {
        new Thread(() ->
                ProviderAPI.get(EndpointCuuHo.class)
                        .create(model)
                        .enqueue(new LamdaNetCallback<>(
                                response -> {
                                    DTO<CuuHo> dto = new DTO<>();
                                    Event event = new Event();
                                    event.setType(Constant.EVENT_TYPE.CREATE_CUUHO);
                                    if (response.code() == 200){
                                        dto.setModel(response.body());
                                        event.setState(Constant.STATE.SUCCESS);
                                    } else {
                                        dto.setModel(model);
                                        event.setState(Constant.STATE.FAIL);
                                        try {
                                            event.setMessage(response.errorBody().string());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    dto.setEvent(event);
                                    callBack.callback(dto);
                                },
                                error -> {}
                        ))
        ).start();
    }

    @Override
    public void update(CallBack<DTO<CuuHo>> callBack, CuuHo model) {
        new Thread(() ->
                ProviderAPI.get(EndpointCuuHo.class)
                        .update(model.getId(), model)
                        .enqueue(new LamdaNetCallback<>(
                                response -> {
                                    DTO<CuuHo> dto = new DTO<>();
                                    Event event = new Event();
                                    event.setType(Constant.EVENT_TYPE.UPDATE_CUUHO);
                                    if (response.code() == 200){
                                        dto.setModel(response.body());
                                        event.setState(Constant.STATE.SUCCESS);
                                    } else {
                                        dto.setModel(model);
                                        event.setState(Constant.STATE.FAIL);
                                        try {
                                            event.setMessage(response.errorBody().string());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    dto.setEvent(event);
                                    callBack.callback(dto);
                                },
                                error -> {}
                        ))
        ).start();
    }

}
