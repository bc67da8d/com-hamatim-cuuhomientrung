package com.hamatim.cuuhomientrung.callback;

import android.view.View;
import android.widget.AdapterView;

public class SpinnerSelectedCallback implements AdapterView.OnItemSelectedListener {

    private HandleSelecte handleSelecte;

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        handleSelecte.onSelect(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public SpinnerSelectedCallback(HandleSelecte handleSelecte) {
        this.handleSelecte = handleSelecte;
    }

    public interface HandleSelecte {
        void onSelect(int position);
    }

}
