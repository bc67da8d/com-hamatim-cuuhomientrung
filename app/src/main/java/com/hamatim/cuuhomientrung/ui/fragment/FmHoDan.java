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
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.ui.adapter.AdapterHoDan;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.sql.Time;
import java.util.List;

public class FmHoDan extends FmBaseList<HoDan, AdapterHoDan> {
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
    protected AdapterHoDan onCreateAdapter(Context context) {
        return new AdapterHoDan(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        swpLayout = root.findViewById(R.id.swpLayout);
        swpLayout.setOnRefreshListener(() -> ProviderVM.getHoDanVM().loadAllHoDan());
        return root;
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
            swpLayout.setRefreshing(false);
            getAdapter().setmList(list);
            getAdapter().doSort(TimeComparator.getDesc());
            getAdapter().notifyDataSetChanged();
        };
    }
}
