package com.hamatim.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.model.Tinh;
import com.hamatim.cuuhomientrung.provider.ProviderSingleton;
import com.hamatim.cuuhomientrung.repository.RepoCuuHo;
import com.hamatim.cuuhomientrung.repository.RepoTinh;

import java.util.List;

public class VMTinh extends ViewModel {

    private MutableLiveData<List<Tinh>> listTinhLiveData;

    public VMTinh() {
        this.listTinhLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Tinh>> watchListTinh(){
        return listTinhLiveData;
    }

    public void loadAllTinh(){
        ProviderSingleton.get(RepoTinh.class)
                .all(data -> {
                    listTinhLiveData.postValue(data);
                });
    }

}
