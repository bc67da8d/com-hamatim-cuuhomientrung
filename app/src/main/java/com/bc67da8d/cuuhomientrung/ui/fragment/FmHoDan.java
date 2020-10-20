package com.bc67da8d.cuuhomientrung.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.HoDan;
import com.bc67da8d.cuuhomientrung.provider.ProviderVM;
import com.bc67da8d.cuuhomientrung.ui.adapter.AdapterHoDan;
import com.bc67da8d.cuuhomientrung.ui.viewmodel.VMHoDan;

import java.util.List;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ProviderVM.getHoDanVM().watchListHoDan()
                .observe(getViewLifecycleOwner(), getListHoDanWatcher());

        ProviderVM.getHoDanVM().loadAllHoDan();
    }

    private Observer<? super List<HoDan>> getListHoDanWatcher() {
        return list -> {
            getAdapter().setmList(list);
            getAdapter().notifyDataSetChanged();
        };
    }
}
