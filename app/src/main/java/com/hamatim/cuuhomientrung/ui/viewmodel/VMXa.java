package com.hamatim.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamatim.cuuhomientrung.model.Tinh;
import com.hamatim.cuuhomientrung.model.Xa;
import com.hamatim.cuuhomientrung.provider.ProviderSingleton;
import com.hamatim.cuuhomientrung.repository.RepoTinh;
import com.hamatim.cuuhomientrung.repository.RepoXa;

import java.util.List;

public class VMXa extends ViewModel {

    private MutableLiveData<List<Xa>> listXaLiveData;

    public VMXa() {
        this.listXaLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Xa>> watchListXa(){
        return listXaLiveData;
    }

    public void loadAllXa(){
        ProviderSingleton.get(RepoXa.class)
                .all(data -> {
                    listXaLiveData.postValue(data);
                });
    }

}
