package com.hamatim.cuuhomientrung.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.ui.adapter.AdapterHoDan;

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
