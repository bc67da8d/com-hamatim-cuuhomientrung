package com.bc67da8d.cuuhomientrung.ui.fragment;

import android.content.Context;

import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.CuuHo;
import com.bc67da8d.cuuhomientrung.ui.adapter.AdapterCuuHo;

public class FmCuuHo extends FmBaseList<CuuHo, AdapterCuuHo> {

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_list;
    }

    @Override
    protected int getListViewId() {
        return R.id.rcvRoot;
    }

    @Override
    protected AdapterCuuHo onCreateAdapter(Context context) {
        return new AdapterCuuHo(context);
    }

}
