package com.hamatim.cuuhomientrung.util;

import com.hamatim.cuuhomientrung.model.HoDan;

import org.joda.time.Instant;

import java.util.Comparator;

public class TimeComparator implements Comparator<TimeComparator.TimeShortable> {

    private int direction = 1;

    public static TimeComparator getDesc(){
        return new TimeComparator(-1);
    }

    public static TimeComparator getAsc(){
        return new TimeComparator(1);
    }

    public TimeComparator(int direction) {
        this.direction = direction;
    }

    @Override
    public int compare(TimeShortable model1, TimeShortable model2) {
        Instant instant1 = Instant.parse(model1.getTime());
        Instant instant2 = Instant.parse(model2.getTime());
        return instant1.compareTo(instant2)*direction;
    }

    public static interface TimeShortable {
        String getTime();
    }
}
