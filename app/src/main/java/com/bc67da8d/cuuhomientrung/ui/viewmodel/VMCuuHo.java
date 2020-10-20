package com.bc67da8d.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bc67da8d.cuuhomientrung.model.CuuHo;
import com.bc67da8d.cuuhomientrung.provider.ProviderSingleton;
import com.bc67da8d.cuuhomientrung.repository.RepoCuuHo;
import com.bc67da8d.cuuhomientrung.repository.RepoHoDan;

import java.util.List;

public class VMCuuHo extends ViewModel {

    private MutableLiveData<List<CuuHo>> listCuuHoLiveData;

    public VMCuuHo() {
        this.listCuuHoLiveData = new MutableLiveData<>();
    }

    public LiveData<List<CuuHo>> watchListCuuHo(){
        return listCuuHoLiveData;
    }

    public void loadAllCuuHo(){
        ProviderSingleton.get(RepoCuuHo.class)
                .all(data -> {
                    listCuuHoLiveData.postValue(data);
                });
    }

}
