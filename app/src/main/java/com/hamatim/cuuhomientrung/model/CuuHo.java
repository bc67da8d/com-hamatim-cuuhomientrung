package com.hamatim.cuuhomientrung.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hamatim.cuuhomientrung.util.TimeComparator;

public class CuuHo implements TimeComparator.TimeShortable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("update_time")
    @Expose
    private String updateTime;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("location")
    @Expose
    private String location;
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
    @SerializedName("volunteer")
    @Expose
    private Integer volunteer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Integer volunteer) {
        this.volunteer = volunteer;
    }

    @Override
    public String getTime() {
        return getUpdateTime();
    }
}