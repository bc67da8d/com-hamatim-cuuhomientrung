package com.hamatim.cuuhomientrung.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.callback.ViewCallBack;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.ui.adapter.AdapterHoDan;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.sql.Time;
import java.util.List;

public class FmHoDan extends FmBaseList<HoDan, AdapterHoDan> implements ViewCallBack<HoDan> {

    SwipeRefreshLayout swpLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_hodan_list;
    }

    @Override
    protected int getListViewId() {
        return R.id.rcvRoot;
    }

    public FmHoDan() {
        setHasOptionsMenu(true);
    }

    @Override
    protected AdapterHoDan onCreateAdapter(Context context) {
        AdapterHoDan adapterHoDan = new AdapterHoDan(context);
        adapterHoDan.setViewCallBack(this);
        return adapterHoDan;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        swpLayout = root.findViewById(R.id.swpLayout);
        swpLayout.setOnRefreshListener(() -> ProviderVM.getHoDanVM().loadAllHoDan());
        return root;
    }

    private void navToEditHoDan(HoDan data) {
        HoDan hoDan = new HoDan();
        hoDan.clone(data);
        ProviderVM.getHoDanVM().initFormHoDan(hoDan);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_fmHoDan_to_fmHoDanEdit);
    }

    private void navToCreateHoDan() {
        HoDan hoDan = new HoDan();
        ProviderVM.getHoDanVM().initFormHoDan(hoDan);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_fmHoDan_to_fmHoDanCreate);
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
            getAdapter().notifyDataSetChanged();
        };
    }

    @Override
    public void callback(View view, HoDan data) {
        showToast(data.getName());
        navToEditHoDan(data);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuCreate:
                navToCreateHoDan();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_hodan_list, menu);
    }
}
