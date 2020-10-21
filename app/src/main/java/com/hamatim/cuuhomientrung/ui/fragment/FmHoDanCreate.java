package com.hamatim.cuuhomientrung.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.model.Huyen;
import com.hamatim.cuuhomientrung.model.Tinh;
import com.hamatim.cuuhomientrung.model.TinhNguyenVien;
import com.hamatim.cuuhomientrung.model.Xa;
import com.hamatim.cuuhomientrung.provider.ProviderVM;

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
    private HoDan formHodan;
    private Button btSubmit;
    private EditText edtName, edtLocation, edtPhone;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_hodan_create;
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

        btSubmit = root.findViewById(R.id.btSubmit);

        spStatus.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setStatus));
        spTinh.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setTinh));
        spHuyen.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setHuyen));
        spXa.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setXa));
        spTinhNguyenVien.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setTinhNguyenVien));
        spCuuHo.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setCuuHo));

        btSubmit.setOnClickListener(onClick -> submitForm());
        return root;
    }

    private void submitForm() {
        getFormHodan().setName(edtName.getText().toString());
        getFormHodan().setLocation(edtLocation.getText().toString());
        getFormHodan().setPhone(edtPhone.getText().toString());

        ProviderVM.getHoDanVM().create(getFormHodan());
    }

    private void setStatus(int position) {
        getFormHodan().setStatus(position);
    }

    private void setCuuHo(int position) {
        if (position < 1){
            getFormHodan().setCuuho(null);
        } else {
            CuuHo cuuHo = ProviderVM.getCuuHoVM()
                    .watchListCuuHo().getValue().get(position - 1);
            getFormHodan().setCuuho(cuuHo.getId());
        }
    }

    private void setTinhNguyenVien(int position) {
        if (position < 1){
            getFormHodan().setVolunteer(null);
        } else {
            TinhNguyenVien tinhNguyenVien = ProviderVM.getTinhNguyenVienVM()
                    .watchListTinhNguyenVien().getValue().get(position - 1);
            getFormHodan().setVolunteer(tinhNguyenVien.getId());
        }
    }

    private void setTinh(int position) {
        if (position < 1){
            getFormHodan().setTinh(null);
        } else {
            Tinh tinh = ProviderVM.getTinhVM()
                    .watchListTinh().getValue().get(position - 1);
            getFormHodan().setTinh(tinh.getId());
        }
    }

    private void setHuyen(int position) {
        if (position < 1){
            getFormHodan().setHuyen(null);
        } else {
            Huyen huyen = ProviderVM.getHuyenVM()
                    .watchListHuyen().getValue().get(position - 1);
            getFormHodan().setHuyen(huyen.getId());
        }
    }

    private void setXa(int position) {
        if (position < 1){
            getFormHodan().setXa(null);
        } else {
            Xa xa = ProviderVM.getXaVM()
                    .watchListXa().getValue().get(position - 1);
            getFormHodan().setXa(xa.getId());
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

        ProviderVM.getCuuHoVM().watchListCuuHo()
                .observe(getViewLifecycleOwner(), getCuuHoListWatcher());

        ProviderVM.getTinhVM().loadAllTinh();
        ProviderVM.getHuyenVM().loadAllHuyen();
        ProviderVM.getXaVM().loadAllXa();
        ProviderVM.getTinhNguyenVienVM().loadAllTinhNuyenVien();
        ProviderVM.getCuuHoVM().loadAllCuuHo();

        attachArrayToSpinner(spStatus, HODAN_STATUS_LIST);
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
                R.layout.layout_item_dropdown,
                R.id.tvName,
                arrayList
        );
        spinner.setAdapter(lAdapter);
    }

    public HoDan getFormHodan() {
        if (formHodan == null){
            formHodan = new HoDan();
        }
        return formHodan;
    }

}
