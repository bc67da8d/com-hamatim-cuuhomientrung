package com.bc67da8d.cuuhomientrung.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.TinhNguyenVien;
import com.bc67da8d.cuuhomientrung.provider.ProviderVM;
import com.bc67da8d.cuuhomientrung.ui.adapter.AdapterTinhNguyenVien;
import com.bc67da8d.cuuhomientrung.ui.viewmodel.VMTinhNguyenVien;

import java.util.List;

public class FmTinhNguyenVien extends FmBaseList<TinhNguyenVien, AdapterTinhNguyenVien> {

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_list;
    }

    @Override
    protected int getListViewId() {
        return R.id.rcvRoot;
    }

    @Override
    protected AdapterTinhNguyenVien onCreateAdapter(Context context) {
        return new AdapterTinhNguyenVien(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ProviderVM.getTinhNguyenVienVM().watchListTinhNguyenVien()
                .observe(getViewLifecycleOwner(), getListTNVWatcher());

        ProviderVM.getTinhNguyenVienVM().loadAllTinhNuyenVien();
    }

    private Observer<? super List<TinhNguyenVien>> getListTNVWatcher() {
        return list -> {
            getAdapter().setmList(list);
            getAdapter().notifyDataSetChanged();
        };
    }
}
