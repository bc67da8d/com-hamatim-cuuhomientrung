package com.hamatim.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamatim.cuuhomientrung.model.DTO;
import com.hamatim.cuuhomientrung.model.Event;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderSingleton;
import com.hamatim.cuuhomientrung.repository.RepoHoDan;

import java.util.List;

public class VMHoDan extends ViewModel {

    private MutableLiveData<List<HoDan>> listHoDanLiveData;
    private MutableLiveData<HoDan> formHoDanLiveData;
    private MutableLiveData<Event> eventLiveData;

    public VMHoDan() {
        this.listHoDanLiveData = new MutableLiveData<>();
        this.formHoDanLiveData = new MutableLiveData<>();
        this.eventLiveData = new MutableLiveData<>();
        HoDan hoDan = new HoDan();
        formHoDanLiveData.setValue(hoDan);
    }

    public LiveData<List<HoDan>> watchListHoDan(){
        return listHoDanLiveData;
    }

    public LiveData<HoDan> watchFormHoDan(){
        return formHoDanLiveData;
    }

    public LiveData<Event> watchEvent(){
        return eventLiveData;
    }

    public void loadAllHoDan(){
        ProviderSingleton.get(RepoHoDan.class)
                .all(data -> {
                    listHoDanLiveData.postValue(data);
                });
    }

    public void create(HoDan formHodan) {
        ProviderSingleton.get(RepoHoDan.class)
                .create(data -> {
                    eventLiveData.postValue(data.getEvent());
                }, formHodan);
    }

    public void update(HoDan formHodan) {
        ProviderSingleton.get(RepoHoDan.class)
                .update(data -> {
                    eventLiveData.postValue(data.getEvent());
                }, formHodan);
    }

    public void initFormHoDan(HoDan hoDan){
        formHoDanLiveData.postValue(hoDan);
    }

    public HoDan getFormHoDan(){
        return formHoDanLiveData.getValue();
    }

    public void eventProcessed() {
        eventLiveData.postValue(new Event());
    }

}
