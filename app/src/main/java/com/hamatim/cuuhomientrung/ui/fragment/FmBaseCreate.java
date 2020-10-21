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

public abstract class FmBaseCreate extends FmBase {

    private Spinner spTinh,
            spXa,
            spHuyen,
            spStatus,
            spTinhNguyenVien;
    protected EditText edtName, edtLocation, edtPhone;

    protected abstract void setStatus(int position);
    protected abstract void setCuuHoId(Integer id);
    protected abstract void setTinhNguyenVienId(Integer id);
    protected abstract void setTinhId(Integer id);
    protected abstract void setHuyenId(Integer id);
    protected abstract void setXaId(Integer id);
    protected abstract Observer<? super Event> getEventWatcher();
    protected abstract void onFormSubmit();
    protected abstract String[] getStatusList();

    public FmBaseCreate() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        spTinh = root.findViewById(R.id.spTinh);
        spHuyen = root.findViewById(R.id.spHuyen);
        spXa = root.findViewById(R.id.spXa);
        spStatus = root.findViewById(R.id.spStatus);
        spTinhNguyenVien = root.findViewById(R.id.spTinhNguyenVien);

        edtName = root.findViewById(R.id.edtName);
        edtLocation = root.findViewById(R.id.edtLocation);
        edtPhone = root.findViewById(R.id.edtPhone);

        spStatus.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setStatus));
        spTinh.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setTinh));
        spHuyen.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setHuyen));
        spXa.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setXa));
        spTinhNguyenVien.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setTinhNguyenVien));

        return root;
    }

    private void prepareSubmitForm() {
        if (validate()) {
            onFormSubmit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itSubmit:
                prepareSubmitForm();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected boolean validate() {
        boolean formValid = true;
        formValid = notBlank(edtName);
        formValid &= notBlank(edtLocation);
        return formValid;
    }

    protected boolean notBlank(EditText editText){
        if (editText.getText().toString().isEmpty()){
            editText.setError("Not blank!");
            return false;
        }
        return true;
    }

    protected void setCuuHo(int position) {
        if (position < 1){
            setCuuHoId(null);
        } else {
            CuuHo cuuHo = ProviderVM.getCuuHoVM()
                    .watchListCuuHo().getValue().get(position - 1);
            setCuuHoId(cuuHo.getId());
        }
    }

    protected void setTinhNguyenVien(int position) {
        if (position < 1){
            setTinhNguyenVienId(null);
        } else {
            TinhNguyenVien tinhNguyenVien = ProviderVM.getTinhNguyenVienVM()
                    .watchListTinhNguyenVien().getValue().get(position - 1);
            setTinhNguyenVienId(tinhNguyenVien.getId());
        }
    }

    protected void setTinh(int position) {
        if (position < 1){
            setTinhId(null);
        } else {
            Tinh tinh = ProviderVM.getTinhVM()
                    .watchListTinh().getValue().get(position - 1);
            setTinhId(tinh.getId());
        }
    }

    protected void setHuyen(int position) {
        if (position < 1){
            setHuyenId(null);
        } else {
            Huyen huyen = ProviderVM.getHuyenVM()
                    .watchListHuyen().getValue().get(position - 1);
            setHuyenId(huyen.getId());
        }
    }

    protected void setXa(int position) {
        if (position < 1){
            setXaId(null);
        } else {
            Xa xa = ProviderVM.getXaVM()
                    .watchListXa().getValue().get(position - 1);
            setXaId(xa.getId());
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ProviderVM.getTinhVM().watchListTinh()
                .observe(getViewLifecycleOwner(), getListTinhWatcher());

        ProviderVM.getHuyenVM().watchListHuyen()
                .observe(getViewLifecycleOwner(), getListHuyenWatcher());

        ProviderVM.getXaVM().watchListXa()
                .observe(getViewLifecycleOwner(), getListXaWatcher());

        ProviderVM.getTinhNguyenVienVM().watchListTinhNguyenVien()
                .observe(getViewLifecycleOwner(), getTNVListWatcher());

        ProviderVM.getHoDanVM().watchEvent()
                .observe(getViewLifecycleOwner(), getEventWatcher());

        ProviderVM.getTinhVM().loadAllTinh();
        ProviderVM.getHuyenVM().loadAllHuyen();
        ProviderVM.getXaVM().loadAllXa();
        ProviderVM.getTinhNguyenVienVM().loadAllTinhNuyenVien();

        attachArrayToSpinner(spStatus, getStatusList());
    }

    private Observer<? super List<TinhNguyenVien>> getTNVListWatcher() {
        return list -> {
            attachArrayToSpinner(spTinhNguyenVien, toStringArray(list));
        };
    }

    private Observer<? super List<Xa>> getListXaWatcher() {
        return list -> {
            attachArrayToSpinner(spXa, toStringArray(list));
        };
    }

    private Observer<? super List<Huyen>> getListHuyenWatcher() {
        return list -> {
            attachArrayToSpinner(spHuyen, toStringArray(list));
        };
    }

    private Observer<? super List<Tinh>> getListTinhWatcher() {
        return list -> {
            attachArrayToSpinner(spTinh, toStringArray(list));
        };
    }

    protected String[] toStringArray(List list) {
        String[] names = new String[list.size() + 1];
        names[0] = "Chưa biết";
        int i = 1;
        for (Object item: list){
            names[i] = item.toString();
            i++;
        }
        return names;
    }

    public void attachArrayToSpinner(Spinner spinner, String[] array) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
        ArrayAdapter<String> lAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList
        );
        spinner.setAdapter(lAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_hodan_create, menu);
    }


}
