package com.hamatim.cuuhomientrung.ui.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.callback.SpinnerSelectedCallback;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.model.Event;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.util.Constant;
import java.util.List;

import static com.hamatim.cuuhomientrung.util.Constant.HODAN_STATUS_LIST;

public class FmHoDanCreate extends FmBaseCreate {

    protected Spinner spCuuHo;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_hodan_create;
    }

    public FmHoDanCreate() {
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        spCuuHo = root.findViewById(R.id.spCuuHo);
        spCuuHo.setOnItemSelectedListener(new SpinnerSelectedCallback(this::setCuuHo));
        return root;
    }

    @Override
    protected void onFormSubmit() {
        getForm().setName(edtName.getText().toString());
        getForm().setLocation(edtLocation.getText().toString());
        getForm().setPhone(edtPhone.getText().toString());
        performSubmit();
    }

    protected void performSubmit() {
        ProviderVM.getHoDanVM().create(getForm());
    }

    @Override
    protected String[] getStatusList() {
        return HODAN_STATUS_LIST;
    }

    @Override
    protected int getCurrentStatus() {
        return mayNull(getForm().getStatus());
    }

    @Override
    protected int getCurrentCuuHoId() {
        return mayNull(getForm().getCuuho());
    }

    @Override
    protected int getCurrentTinhNguyenVienId() {
        return mayNull(getForm().getVolunteer());
    }

    @Override
    protected int getCurrentTinhId() {
        return mayNull(getForm().getTinh());
    }

    @Override
    protected int getCurrentHuyenId() {
        return mayNull(getForm().getHuyen());
    }

    @Override
    protected int getCurrentXaId() {
        return mayNull(getForm().getXa());
    }

    @Override
    protected void setStatus(int id) {
        getForm().setStatus(id);
    }

    @Override
    protected void setCuuHoId(Integer id) {
        getForm().setCuuho(id);
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

    public HoDan getForm(){
        return ProviderVM.getHoDanVM().getForm();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ProviderVM.getHoDanVM().watchForm()
                .observe(getViewLifecycleOwner(), getFormWatcher());
        ProviderVM.getCuuHoVM().watchListCuuHo()
                .observe(getViewLifecycleOwner(), getCuuHoListWatcher());
    }

    @Override
    protected void loadData() {
        super.loadData();
        ProviderVM.getCuuHoVM().loadAllCuuHo();
    }

    private Observer<? super List<CuuHo>> getCuuHoListWatcher() {
        return list -> {
            attachListToSpinner(spCuuHo, getCurrentCuuHoId(), list);
        };
    }

    @Override
    protected Observer<? super Event> getEventWatcher() {
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
                ProviderVM.getEventVM().eventProcessed();
            }
        };
    }

    private Observer<? super HoDan> getFormWatcher() {
        return form -> {
            edtName.setText(form.getName());
            edtLocation.setText(form.getLocation());
            edtPhone.setText(form.getPhone());
            loadData();
        };
    }

}
