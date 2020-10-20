package com.bc67da8d.cuuhomientrung.ui.fragment;

import android.content.Context;
import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.HoDan;
import com.bc67da8d.cuuhomientrung.ui.adapter.AdapterHoDan;

public class FmHoDan extends FmBaseList<HoDan, AdapterHoDan> {

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_list;
    }

    @Override
    protected int getListViewId() {
        return R.id.rcvRoot;
    }

    @Override
    protected AdapterHoDan onCreateAdapter(Context context) {
        return new AdapterHoDan(context);
    }

}
