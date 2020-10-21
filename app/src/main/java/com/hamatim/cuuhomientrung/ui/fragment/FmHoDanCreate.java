package com.hamatim.cuuhomientrung.ui.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

import static com.hamatim.cuuhomientrung.util.Constant.HODAN_STATUS_LIST;

public class FmHoDanCreate extends FmBase {

    private static final String TAG = "FmHoDanCreate";
    private Spinner spTinh,
            spXa,
            spHuyen,
            spStatus,
            spTinhNguyenVien,
            spCuuHo;
    private EditText edtName, edtLocation, edtPhone;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_hodan_create;
    }

    public FmHoDanCreate() {
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
        spCuuHo = root.findViewById(R.id.spCuuHo);

        edtName = root.findViewById(R.id.edtName);
        edtLocation = root.findViewById(R.id.edtLocation);
        edtPhone = root.findViewById(R.id.edtPhone);

        spStatus.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setStatus));
        spTinh.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setTinh));
        spHuyen.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setHuyen));
        spXa.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setXa));
        spTinhNguyenVien.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setTinhNguyenVien));
        spCuuHo.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setCuuHo));

        return root;
    }

    private void submitForm() {
        if (validate()) {
            getFormHoDan().setName(edtName.getText().toString());
            getFormHoDan().setLocation(edtLocation.getText().toString());
            getFormHoDan().setPhone(edtPhone.getText().toString());
            ProviderVM.getHoDanVM().create(getFormHoDan());
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itSubmit:
                submitForm();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean validate() {
        boolean formValid = true;
        formValid = notBlank(edtName);
        formValid &= notBlank(edtLocation);
        return formValid;
    }

    private boolean notBlank(EditText editText){
        if (editText.getText().toString().isEmpty()){
            editText.setError("Not blank!");
            return false;
        }
        return true;
    }

    private void setStatus(int position) {
        getFormHoDan().setStatus(position);
    }

    private void setCuuHo(int position) {
        if (position < 1){
            getFormHoDan().setCuuho(null);
        } else {
            CuuHo cuuHo = ProviderVM.getCuuHoVM()
                    .watchListCuuHo().getValue().get(position - 1);
            getFormHoDan().setCuuho(cuuHo.getId());
        }
    }

    private void setTinhNguyenVien(int position) {
        if (position < 1){
            getFormHoDan().setVolunteer(null);
        } else {
            TinhNguyenVien tinhNguyenVien = ProviderVM.getTinhNguyenVienVM()
                    .watchListTinhNguyenVien().getValue().get(position - 1);
            getFormHoDan().setVolunteer(tinhNguyenVien.getId());
        }
    }

    private void setTinh(int position) {
        if (position < 1){
            getFormHoDan().setTinh(null);
        } else {
            Tinh tinh = ProviderVM.getTinhVM()
                    .watchListTinh().getValue().get(position - 1);
            getFormHoDan().setTinh(tinh.getId());
        }
    }

    private void setHuyen(int position) {
        if (position < 1){
            getFormHoDan().setHuyen(null);
        } else {
            Huyen huyen = ProviderVM.getHuyenVM()
                    .watchListHuyen().getValue().get(position - 1);
            getFormHoDan().setHuyen(huyen.getId());
        }
    }

    private void setXa(int position) {
        if (position < 1){
            getFormHoDan().setXa(null);
        } else {
            Xa xa = ProviderVM.getXaVM()
                    .watchListXa().getValue().get(position - 1);
            getFormHoDan().setXa(xa.getId());
        }
    }

    public HoDan getFormHoDan(){
        return ProviderVM.getHoDanVM().getFormHoDan();
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

        ProviderVM.getCuuHoVM().watchListCuuHo()
                .observe(getViewLifecycleOwner(), getCuuHoListWatcher());

        ProviderVM.getHoDanVM().watchFormHoDan()
                .observe(getViewLifecycleOwner(), getFormHoDanWatcher());

        ProviderVM.getHoDanVM().watchEvent()
                .observe(getViewLifecycleOwner(), getEventWatcher());

        ProviderVM.getTinhVM().loadAllTinh();
        ProviderVM.getHuyenVM().loadAllHuyen();
        ProviderVM.getXaVM().loadAllXa();
        ProviderVM.getTinhNguyenVienVM().loadAllTinhNuyenVien();
        ProviderVM.getCuuHoVM().loadAllCuuHo();

        attachArrayToSpinner(spStatus, HODAN_STATUS_LIST);
    }

    private Observer<? super Event> getEventWatcher() {
        return event -> {
            if (event.getType().equals(Constant.EVENT_TYPE.CREATE_HODAN)){
                if (event.isFailed()) {
                    new AlertDialog.Builder(getContext())
                            .setTitle("Create Ho Dan Alert!")
                            .setMessage(event.getMessage())
                            .show();
                } else {
                    new AlertDialog.Builder(getContext())
                            .setTitle("Create Ho Dan Alert!")
                            .setMessage("Success!")
                            .show();
                }
                ProviderVM.getHoDanVM().eventProcessed();
            }
        };
    }

    private Observer<? super HoDan> getFormHoDanWatcher() {
        return hodan -> {
            edtName.setText(hodan.getName());
            edtLocation.setText(hodan.getLocation());
            edtPhone.setText(hodan.getPhone());
        };
    }

    private Observer<? super List<CuuHo>> getCuuHoListWatcher() {
        return list -> {
            attachArrayToSpinner(spCuuHo, toStringArray(list));
        };
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

    private String[] toStringArray(List list) {
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
