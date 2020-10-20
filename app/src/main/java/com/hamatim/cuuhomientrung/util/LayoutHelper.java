package com.hamatim.cuuhomientrung.util;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

public class LayoutHelper {

    public static LinearLayoutManager getLayoutManager(Context context){
        return new LinearLayoutManager(context);
    }

    public static LinearLayoutManager getGridLayoutManager(Context context, int column){
        return new GridLayoutManager(context, column);
    }

    public static LinearLayoutManager getGridLayoutManager(Context context){
        return new GridLayoutManager(context, 2);
    }

}
