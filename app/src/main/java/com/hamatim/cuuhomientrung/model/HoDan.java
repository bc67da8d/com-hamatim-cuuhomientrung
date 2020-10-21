package com.hamatim.cuuhomientrung.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hamatim.cuuhomientrung.util.TimeComparator;

public class HoDan extends BasicModel implements TimeComparator.TimeShortable {

    @SerializedName("cuuho")
    @Expose
    private Integer cuuho;

    @SerializedName("volunteer")
    @Expose
    private Integer volunteer;

    public Integer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Integer volunteer) {
        this.volunteer = volunteer;
    }

    public Integer getCuuho() {
        return cuuho;
    }

    public void setCuuho(Integer cuuho) {
        this.cuuho = cuuho;
    }

    @Override
    public String getTime() {
        return getUpdateTime();
    }

    public void clone(HoDan hoDan) {
        super.clone(hoDan);
        setCuuho(hoDan.getCuuho());
        setVolunteer(hoDan.getVolunteer());
    }

}