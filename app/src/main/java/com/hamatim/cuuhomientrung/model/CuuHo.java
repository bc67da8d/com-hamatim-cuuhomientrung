package com.hamatim.cuuhomientrung.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hamatim.cuuhomientrung.util.TimeComparator;

public class CuuHo extends BasicModel implements TimeComparator.TimeShortable {

    @SerializedName("volunteer")
    @Expose
    private Integer volunteer;

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

    public void clone(CuuHo cuuHo){
        super.clone(cuuHo);
        setVolunteer(cuuHo.getVolunteer());
    }

}