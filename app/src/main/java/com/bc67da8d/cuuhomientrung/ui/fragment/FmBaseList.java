package com.bc67da8d.cuuhomientrung.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bc67da8d.cuuhomientrung.ui.adapter.AdapterBase;
import com.bc67da8d.cuuhomientrung.util.LayoutHelper;

public abstract class FmBaseList<M, A extends AdapterBase> extends FmBase {

    private RecyclerView recyclerView;
    private A adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        recyclerView = root.findViewById(getListViewId());
        recyclerView.setLayoutManager(LayoutHelper.getLayoutManager(getContext()));
        recyclerView.setAdapter(getAdapter());
        return root;
    }

    protected abstract int getLayoutId();

    protected abstract int getListViewId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public A getAdapter() {
        if (adapter == null){
            adapter = onCreateAdapter(getContext());
        }
        return adapter;
    }

    protected abstract A onCreateAdapter(Context context);
}
