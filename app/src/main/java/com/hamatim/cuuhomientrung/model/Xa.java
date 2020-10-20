package com.hamatim.cuuhomientrung.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Xa {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("huyen")
@Expose
private Object huyen;

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

public Object getHuyen() {
return huyen;
}

public void setHuyen(Object huyen) {
this.huyen = huyen;
}

}