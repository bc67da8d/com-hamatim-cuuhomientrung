package com.hamatim.cuuhomientrung.ui.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.callback.SpinnerSelectedCallback;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.model.Event;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.model.Huyen;
import com.hamatim.cuuhomientrung.model.Tinh;
import com.hamatim.cuuhomientrung.model.TinhNguyenVien;
import com.hamatim.cuuhomientrung.model.Xa;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.util.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hamatim.cuuhomientrung.util.Constant.CUUHO_STATUS_LIST;
import static com.hamatim.cuuhomientrung.util.Constant.HODAN_STATUS_LIST;

public class FmCuuHoCreate extends FmBaseCreate {

    protected CuuHo getForm(){
        return ProviderVM.getCuuHoVM().getForm();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ProviderVM.getCuuHoVM().watchForm()
                .observe(getViewLifecycleOwner(), getFormWatcher());
    }

    private Observer<? super CuuHo> getFormWatcher() {
        return form -> {
            edtName.setText(form.getName());
            edtLocation.setText(form.getLocation());
            edtPhone.setText(form.getPhone());
            loadData();
        };
    }

    @Override
    protected void setStatus(int id) {
        getForm().setStatus(id);
    }

    @Override
    protected void setCuuHoId(Integer id) {
    }

    @Override
    protected void setTinhNguyenVienId(Integer id) {
        getForm().setVolunteer(id);
    }

    @Override
    protected void setTinhId(Integer id) {
        getForm().setTinh(id);
    }

    @Override
    protected void setHuyenId(Integer id) {
        getForm().setHuyen(id);
    }

    @Override
    protected void setXaId(Integer id) {
        getForm().setXa(id);
    }

    @Override
    protected Observer<? super Event> getEventWatcher() {
        return event -> {
        };
    }

    @Override
    protected void onFormSubmit() {
        getForm().setName(edtName.getText().toString());
        getForm().setLocation(edtLocation.getText().toString());
        getForm().setPhone(edtPhone.getText().toString());
        performSubmit();
    }

    protected void performSubmit() {
        ProviderVM.getCuuHoVM().create(getForm());
    }

    @Override
    protected String[] getStatusList() {
        return CUUHO_STATUS_LIST;
    }

    @Override
    protected int getCurrentStatus() {
        return 0;
    }

    @Override
    protected int getCurrentCuuHoId() {
        return 0;
    }

    @Override
    protected int getCurrentTinhNguyenVienId() {
        return 0;
    }

    @Override
    protected int getCurrentTinhId() {
        return 0;
    }

    @Override
    protected int getCurrentHuyenId() {
        return 0;
    }

    @Override
    protected int getCurrentXaId() {
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_cuuho_create;
    }

}
