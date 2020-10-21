package com.hamatim.cuuhomientrung.ui.fragment;

import com.hamatim.cuuhomientrung.provider.ProviderVM;

public class FmHoDanEdit extends FmHoDanCreate {

    @Override
    protected void onFormSubmit() {
        ProviderVM.getHoDanVM().update(getFormHoDan());
    }

}
