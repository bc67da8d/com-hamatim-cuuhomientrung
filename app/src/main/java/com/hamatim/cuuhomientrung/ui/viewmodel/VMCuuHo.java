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
    private MutableLiveData<CuuHo> formLiveData;

    public VMCuuHo() {
        this.listCuuHoLiveData = new MutableLiveData<>();
        this.formLiveData = new MutableLiveData<>();
    }

    public LiveData<List<CuuHo>> watchListCuuHo(){
        return listCuuHoLiveData;
    }

    public LiveData<CuuHo> watchForm(){
        return formLiveData;
    }

    public void loadAllCuuHo(){
        ProviderSingleton.get(RepoCuuHo.class).all(this::sort);
    }

    private void sort(List<CuuHo> data) {
        HelperFormat.sort(list -> listCuuHoLiveData.postValue(list), data, TimeComparator.getDesc());
    }

    public void initForm(CuuHo model){
        formLiveData.postValue(model);
    }

    public CuuHo getForm(){
        return formLiveData.getValue();
    }

    public void create(CuuHo form) {

    }

    public void update(CuuHo form) {

    }

}
