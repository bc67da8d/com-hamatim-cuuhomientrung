package com.hamatim.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamatim.cuuhomientrung.model.DTO;
import com.hamatim.cuuhomientrung.model.Event;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderSingleton;
import com.hamatim.cuuhomientrung.repository.RepoHoDan;
import com.hamatim.cuuhomientrung.util.HelperFormat;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.sql.Time;
import java.util.Collections;
import java.util.List;

public class VMHoDan extends ViewModel {

    private MutableLiveData<List<HoDan>> listHoDanLiveData;
    private MutableLiveData<HoDan> formLiveData;
    private MutableLiveData<Event> eventLiveData;

    public VMHoDan() {
        this.listHoDanLiveData = new MutableLiveData<>();
        this.formLiveData = new MutableLiveData<>();
        this.eventLiveData = new MutableLiveData<>();
        HoDan hoDan = new HoDan();
        formLiveData.setValue(hoDan);
    }

    public LiveData<List<HoDan>> watchListHoDan(){
        return listHoDanLiveData;
    }

    public LiveData<HoDan> watchForm(){
        return formLiveData;
    }

    public LiveData<Event> watchEvent(){
        return eventLiveData;
    }

    public void loadAllHoDan(){
        ProviderSingleton.get(RepoHoDan.class).all(this::sort);
    }

    private void sort(List<HoDan> data) {
        HelperFormat.sort(list -> listHoDanLiveData.postValue(list), data, TimeComparator.getDesc());
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

    public void initForm(HoDan hoDan){
        formLiveData.postValue(hoDan);
    }

    public HoDan getForm(){
        return formLiveData.getValue();
    }

    public void eventProcessed() {
        eventLiveData.postValue(new Event());
    }

}
