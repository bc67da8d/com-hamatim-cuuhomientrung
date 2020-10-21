package com.hamatim.cuuhomientrung.ui.fragment;

import androidx.lifecycle.Observer;

import com.hamatim.cuuhomientrung.model.Event;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.util.Constant;

public class FmCuuHoEdit extends FmCuuHoCreate {

    @Override
    protected void performSubmit() {
        ProviderVM.getCuuHoVM().update(getForm());
    }

    @Override
    protected Observer<? super Event> getEventWatcher() {
        return event -> {
            if (event.getType().equals(Constant.EVENT_TYPE.UPDATE_CUUHO)){
                if (event.isFailed()) {
                    showAlert("Update ho dan alert", event.getMessage());
                } else {
                    showAlert("Update ho dan alert", "Success");
                }
                ProviderVM.getEventVM().eventProcessed();
            }
        };
    }
}
