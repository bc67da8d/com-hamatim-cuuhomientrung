package com.hamatim.cuuhomientrung.ui.fragment;

import android.app.AlertDialog;

import androidx.lifecycle.Observer;

import com.hamatim.cuuhomientrung.model.Event;
import com.hamatim.cuuhomientrung.provider.ProviderVM;
import com.hamatim.cuuhomientrung.util.Constant;

public class FmHoDanEdit extends FmHoDanCreate {

    @Override
    protected void onFormSubmit() {
        ProviderVM.getHoDanVM().update(getFormHoDan());
    }

    @Override
    protected Observer<? super Event> getEventWatcher() {
        return event -> {
            if (event.getType().equals(Constant.EVENT_TYPE.UPDATE_HODAN)){
                if (event.isFailed()) {
                    showAlert("Update ho dan alert", event.getMessage());
                } else {
                    showAlert("Update ho dan alert", "Success");
                }
                ProviderVM.getHoDanVM().eventProcessed();
            }
        };
    }
}
