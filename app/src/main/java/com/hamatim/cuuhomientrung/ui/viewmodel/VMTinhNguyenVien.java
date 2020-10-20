package com.hamatim.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamatim.cuuhomientrung.model.TinhNguyenVien;
import com.hamatim.cuuhomientrung.provider.ProviderSingleton;
import com.hamatim.cuuhomientrung.repository.RepoTinhNguyenVien;

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
