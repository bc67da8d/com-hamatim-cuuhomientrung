package com.bc67da8d.cuuhomientrung.ui.fragment;

import android.content.Context;

import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.TinhNguyenVien;
import com.bc67da8d.cuuhomientrung.ui.adapter.AdapterTinhNguyenVien;

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

}
