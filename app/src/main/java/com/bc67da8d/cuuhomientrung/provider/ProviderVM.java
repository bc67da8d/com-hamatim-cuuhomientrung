package com.bc67da8d.cuuhomientrung.provider;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bc67da8d.cuuhomientrung.MainApplication;
import com.bc67da8d.cuuhomientrung.ui.viewmodel.VMCuuHo;
import com.bc67da8d.cuuhomientrung.ui.viewmodel.VMHoDan;
import com.bc67da8d.cuuhomientrung.ui.viewmodel.VMTinhNguyenVien;

import java.util.HashMap;

public class ProviderVM {

    private static HashMap<String, Object> cached;

    private ProviderVM(){
        //construction, can be private
    }

    public static <T extends ViewModel> T get(final Class<T> service) {
        if (null == getCache().get(service.getCanonicalName())) {
            getCache().put(service.getCanonicalName(), getViewModel(service));
        }
        return (T) getCache().get(service.getCanonicalName());
    }

    private static HashMap<String, Object> getCache() {
        if (null == cached){
            cached = new HashMap<>();
        }
        return cached;
    }

    private static <T extends ViewModel> T getViewModel(Class<T> service) {
        return ViewModelProvider.AndroidViewModelFactory
                .getInstance(MainApplication.getInstance())
                .create(service);
    }

    public static VMTinhNguyenVien getTinhNguyenVienVM(){
        return get(VMTinhNguyenVien.class);
    }

    public static VMCuuHo getCuuHoVM(){
        return get(VMCuuHo.class);
    }

    public static VMHoDan getHoDanVM(){
        return get(VMHoDan.class);
    }

}