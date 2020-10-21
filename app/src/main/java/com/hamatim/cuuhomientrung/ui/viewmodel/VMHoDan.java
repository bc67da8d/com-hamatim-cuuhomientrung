package com.hamatim.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderSingleton;
import com.hamatim.cuuhomientrung.repository.RepoHoDan;

import java.util.List;

public class VMHoDan extends ViewModel {

    private MutableLiveData<List<HoDan>> listHoDanLiveData;

    public VMHoDan() {
        this.listHoDanLiveData = new MutableLiveData<>();
    }

    public LiveData<List<HoDan>> watchListHoDan(){
        return listHoDanLiveData;
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

                }, formHodan);
    }
}
