package com.hamatim.cuuhomientrung.util;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hamatim.cuuhomientrung.R;

import java.util.ArrayList;
import java.util.Arrays;

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
