package com.hamatim.cuuhomientrung.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.ui.adapter.AdapterCuuHo;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.util.List;

public class FmCuuHo extends FmBaseList<CuuHo, AdapterCuuHo> {

    SwipeRefreshLayout swpLayout;

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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        swpLayout = root.findViewById(R.id.swpLayout);
        swpLayout.setOnRefreshListener(() -> ProviderVM.getCuuHoVM().loadAllCuuHo());
        return root;
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
            swpLayout.setRefreshing(false);
            getAdapter().setmList(list);
            getAdapter().doSort(TimeComparator.getDesc());
            getAdapter().notifyDataSetChanged();
        };
    }
}
