package com.hamatim.cuuhomientrung.provider;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.hamatim.cuuhomientrung.MainApplication;
import com.hamatim.cuuhomientrung.ui.viewmodel.VMCuuHo;
import com.hamatim.cuuhomientrung.ui.viewmodel.VMEvent;
import com.hamatim.cuuhomientrung.ui.viewmodel.VMHoDan;
import com.hamatim.cuuhomientrung.ui.viewmodel.VMHuyen;
import com.hamatim.cuuhomientrung.ui.viewmodel.VMTinh;
import com.hamatim.cuuhomientrung.ui.viewmodel.VMTinhNguyenVien;
import com.hamatim.cuuhomientrung.ui.viewmodel.VMXa;

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

    public static VMTinh getTinhVM(){
        return get(VMTinh.class);
    }

    public static VMHuyen getHuyenVM(){
        return get(VMHuyen.class);
    }

    public static VMXa getXaVM(){
        return get(VMXa.class);
    }

    public static VMHoDan getHoDanVM(){
        return get(VMHoDan.class);
    }

    public static VMEvent getEventVM(){
        return get(VMEvent.class);
    }

}
