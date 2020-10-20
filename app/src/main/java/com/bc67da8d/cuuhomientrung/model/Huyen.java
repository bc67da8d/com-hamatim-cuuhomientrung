package com.bc67da8d.cuuhomientrung.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Huyen {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("tinh")
@Expose
private Object tinh;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Object getTinh() {
return tinh;
}

public void setTinh(Object tinh) {
this.tinh = tinh;
}

}