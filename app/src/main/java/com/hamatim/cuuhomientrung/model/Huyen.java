package com.hamatim.cuuhomientrung.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Huyen extends Base {

    @SerializedName("tinh")
    @Expose
    private Object tinh;

    public Object getTinh() {
        return tinh;
    }

    public void setTinh(Object tinh) {
        this.tinh = tinh;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}