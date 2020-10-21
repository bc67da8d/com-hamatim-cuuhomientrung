package com.hamatim.cuuhomientrung.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class BasicModel extends Base {

    @SerializedName("update_time")
    @Expose
    private String updateTime;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("tinh")
    @Expose
    private Integer tinh;
    @SerializedName("huyen")
    @Expose
    private Integer huyen;
    @SerializedName("xa")
    @Expose
    private Integer xa;
    @SerializedName("thon")
    @Expose
    private Integer thon;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTinh() {
        return tinh;
    }

    public void setTinh(Integer tinh) {
        this.tinh = tinh;
    }

    public Integer getHuyen() {
        return huyen;
    }

    public void setHuyen(Integer huyen) {
        this.huyen = huyen;
    }

    public Integer getXa() {
        return xa;
    }

    public void setXa(Integer xa) {
        this.xa = xa;
    }

    public Integer getThon() {
        return thon;
    }

    public void setThon(Integer thon) {
        this.thon = thon;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }

    public void clone(BasicModel hoDan) {
        setId(hoDan.getId());
        setUpdateTime(hoDan.getUpdateTime());

        setLocation(hoDan.getLocation());
        setTinh(hoDan.getTinh());
        setHuyen(hoDan.getHuyen());
        setXa(hoDan.getXa());
        setThon(hoDan.getThon());

        setName(hoDan.getName());
        setPhone(hoDan.getPhone());
        setStatus(hoDan.getStatus());
        setNote(hoDan.getNote());
    }

}