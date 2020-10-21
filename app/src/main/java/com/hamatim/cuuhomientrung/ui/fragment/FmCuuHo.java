package com.hamatim.cuuhomientrung.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.callback.ViewCallBack;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.ui.adapter.AdapterCuuHo;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.util.List;

public class FmCuuHo extends FmBaseList<CuuHo, AdapterCuuHo> implements ViewCallBack<CuuHo> {

    SwipeRefreshLayout swpLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_list;
    }

    @Override
    protected int getListViewId() {
        return R.id.rcvRoot;
    }

    public FmCuuHo() {
        setHasOptionsMenu(true);
    }

    @Override
    protected AdapterCuuHo onCreateAdapter(Context context) {
        AdapterCuuHo adapterCuuHo = new AdapterCuuHo(context);
        adapterCuuHo.setViewCallBack(this);
        return adapterCuuHo;
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
            getAdapter().notifyDataSetChanged();
        };
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuCreate:
                navToCreate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void navToCreate() {
        CuuHo cuuHo = new CuuHo();
        ProviderVM.getCuuHoVM().initForm(cuuHo);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_fmCuuHo_to_fmCuuHoCreate);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_cuuho_list, menu);
    }

    @Override
    public void callback(View view, CuuHo data) {
        navToEdit(data);
    }

    private void navToEdit(CuuHo data) {
        CuuHo cuuHo = new CuuHo();
        cuuHo.clone(data);
        ProviderVM.getCuuHoVM().initForm(cuuHo);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_fmCuuHo_to_fmCuuHoEdit);
    }

}
