package com.bc67da8d.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bc67da8d.cuuhomientrung.callback.CallBack;
import com.bc67da8d.cuuhomientrung.model.HoDan;
import com.bc67da8d.cuuhomientrung.model.TinhNguyenVien;
import com.bc67da8d.cuuhomientrung.provider.ProviderSingleton;
import com.bc67da8d.cuuhomientrung.repository.RepoTinhNguyenVien;

import java.util.List;

public class VMTinhNguyenVien extends ViewModel {

    private MutableLiveData<List<TinhNguyenVien>> listTinhNguyenVienLiveData;

    public VMTinhNguyenVien() {
        this.listTinhNguyenVienLiveData = new MutableLiveData<>();
    }

    public LiveData<List<TinhNguyenVien>> watchListTinhNguyenVien(){
        return listTinhNguyenVienLiveData;
    }

    public void loadAllTinhNuyenVien(){
        ProviderSingleton.get(RepoTinhNguyenVien.class)
                .all(data -> {
                    listTinhNguyenVienLiveData.postValue(data);
                });
    }

}
