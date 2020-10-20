package com.hamatim.cuuhomientrung.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.ui.adapter.AdapterCuuHo;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.util.List;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ProviderVM.getCuuHoVM().watchListCuuHo()
                .observe(getViewLifecycleOwner(), getListCuuHoWatcher());

        ProviderVM.getCuuHoVM().loadAllCuuHo();
    }

    private Observer<? super List<CuuHo>> getListCuuHoWatcher() {
        return list -> {
            getAdapter().setmList(list);
            getAdapter().doSort(TimeComparator.getDesc());
            getAdapter().notifyDataSetChanged();
        };
    }
}
