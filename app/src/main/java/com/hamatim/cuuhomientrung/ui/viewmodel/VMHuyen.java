package com.hamatim.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamatim.cuuhomientrung.model.Huyen;
import com.hamatim.cuuhomientrung.model.Tinh;
import com.hamatim.cuuhomientrung.provider.ProviderSingleton;
import com.hamatim.cuuhomientrung.repository.RepoHuyen;
import com.hamatim.cuuhomientrung.repository.RepoTinh;

import java.util.List;

public class VMHuyen extends ViewModel {

    private MutableLiveData<List<Huyen>> listHuyenLiveData;

    public VMHuyen() {
        this.listHuyenLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Huyen>> watchListHuyen(){
        return listHuyenLiveData;
    }

    public void loadAllHuyen(){
        ProviderSingleton.get(RepoHuyen.class)
                .all(data -> {
                    listHuyenLiveData.postValue(data);
                });
    }

}
