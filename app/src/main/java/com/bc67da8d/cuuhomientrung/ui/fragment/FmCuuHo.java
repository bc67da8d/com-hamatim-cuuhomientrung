package com.bc67da8d.cuuhomientrung.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.CuuHo;
import com.bc67da8d.cuuhomientrung.provider.ProviderVM;
import com.bc67da8d.cuuhomientrung.ui.adapter.AdapterCuuHo;
import com.bc67da8d.cuuhomientrung.ui.viewmodel.VMCuuHo;

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
            getAdapter().notifyDataSetChanged();
        };
    }
}
