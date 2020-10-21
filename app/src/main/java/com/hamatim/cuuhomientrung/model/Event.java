package com.hamatim.cuuhomientrung.model;

import com.hamatim.cuuhomientrung.util.Constant;

public class Event {

    private String message;
    private Constant.STATE state;
    private Constant.EVENT_TYPE type;

    public Event() {
        this.type = Constant.EVENT_TYPE.UNKNOWN;
        this.state = Constant.STATE.UNKNOWN;
        this.message = "N?A";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Constant.STATE getState() {
        return state;
    }

    public void setState(Constant.STATE state) {
        this.state = state;
    }

    public Constant.EVENT_TYPE getType() {
        return type;
    }

    public void setType(Constant.EVENT_TYPE type) {
        this.type = type;
    }

    public boolean isFailed() {
        return getState().equals(Constant.STATE.FAIL);
    }

    public boolean isSuccess() {
        return getState().equals(Constant.STATE.SUCCESS);
    }

}
