package com.bc67da8d.cuuhomientrung.ui.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class VHBase<M> extends RecyclerView.ViewHolder {

    private M model;

    public VHBase(@NonNull View itemView) {
        super(itemView);
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
        notifyDataSetChanged();
    }

    public abstract void notifyDataSetChanged();

}
