package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.callback.LamdaNetCallback;
import com.hamatim.cuuhomientrung.endpoint.EndpointHoDan;
import com.hamatim.cuuhomientrung.model.DTO;
import com.hamatim.cuuhomientrung.model.Event;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderAPI;
import com.hamatim.cuuhomientrung.util.Constant;

import java.io.IOException;
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

    @Override
    public void create(CallBack<DTO<HoDan>> callBack, HoDan hoDan) {
        new Thread(() ->
                ProviderAPI.get(EndpointHoDan.class)
                        .create(hoDan)
                        .enqueue(new LamdaNetCallback<>(
                                response -> {
                                    DTO<HoDan> hoDanDTO = new DTO<>();
                                    Event event = new Event();
                                    event.setType(Constant.EVENT_TYPE.CREATE_HODAN);
                                    if (response.code() == 200){
                                        hoDanDTO.setModel(response.body());
                                        event.setState(Constant.STATE.SUCCESS);
                                    } else {
                                        hoDanDTO.setModel(hoDan);
                                        event.setState(Constant.STATE.FAIL);
                                        try {
                                            event.setMessage(response.errorBody().string());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    hoDanDTO.setEvent(event);
                                    callBack.callback(hoDanDTO);
                                },
                                error -> {}
                        ))
        ).start();
    }

    @Override
    public void update(CallBack<DTO<HoDan>> callBack, HoDan hoDan) {
        new Thread(() ->
                ProviderAPI.get(EndpointHoDan.class)
                        .update(hoDan.getId(), hoDan)
                        .enqueue(new LamdaNetCallback<>(
                                response -> {
                                    DTO<HoDan> hoDanDTO = new DTO<>();
                                    Event event = new Event();
                                    event.setType(Constant.EVENT_TYPE.UPDATE_HODAN);
                                    if (response.code() == 200){
                                        hoDanDTO.setModel(response.body());
                                        event.setState(Constant.STATE.SUCCESS);
                                    } else {
                                        hoDanDTO.setModel(hoDan);
                                        event.setState(Constant.STATE.FAIL);
                                        try {
                                            event.setMessage(response.errorBody().string());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    hoDanDTO.setEvent(event);
                                    callBack.callback(hoDanDTO);
                                },
                                error -> {}
                        ))
        ).start();
    }

}
