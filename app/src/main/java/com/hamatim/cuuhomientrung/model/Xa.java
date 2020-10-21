package com.hamatim.cuuhomientrung.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Xa extends Base {

    @SerializedName("huyen")
    @Expose
    private Object huyen;

    public Object getHuyen() {
        return huyen;
    }

    public void setHuyen(Object huyen) {
        this.huyen = huyen;
    }

}