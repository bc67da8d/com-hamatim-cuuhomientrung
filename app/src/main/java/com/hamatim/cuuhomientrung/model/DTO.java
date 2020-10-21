package com.hamatim.cuuhomientrung.model;

import com.hamatim.cuuhomientrung.util.Constant;

public class DTO<M> {

    private M model;
    private Event event;

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
