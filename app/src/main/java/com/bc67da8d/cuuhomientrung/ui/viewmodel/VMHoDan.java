package com.bc67da8d.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bc67da8d.cuuhomientrung.model.HoDan;
import com.bc67da8d.cuuhomientrung.provider.ProviderSingleton;
import com.bc67da8d.cuuhomientrung.repository.RepoHoDan;
import com.bc67da8d.cuuhomientrung.repository.RepoTinhNguyenVien;

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

}
