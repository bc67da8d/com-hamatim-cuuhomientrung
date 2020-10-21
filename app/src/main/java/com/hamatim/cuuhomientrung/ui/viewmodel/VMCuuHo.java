package com.hamatim.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderSingleton;
import com.hamatim.cuuhomientrung.repository.RepoCuuHo;
import com.hamatim.cuuhomientrung.util.HelperFormat;
import com.hamatim.cuuhomientrung.util.TimeComparator;

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
        ProviderSingleton.get(RepoCuuHo.class).all(this::sort);
    }

    private void sort(List<CuuHo> data) {
        HelperFormat.sort(list -> listCuuHoLiveData.postValue(list), data, TimeComparator.getDesc());
    }

}
