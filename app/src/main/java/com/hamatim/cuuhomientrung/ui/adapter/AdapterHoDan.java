package com.hamatim.cuuhomientrung.ui.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.ui.viewholder.VHHoDan;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.util.Collections;
import java.util.Comparator;

public class AdapterHoDan extends AdapterBase<HoDan, VHHoDan> {

    public AdapterHoDan(Context mContext) {
        super(mContext);
    }

    @Override
    protected VHHoDan onCreateViewHolder(View root) {
        return new VHHoDan(root);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_item_hodan;
    }

    @Override
    public void onBindViewHolder(@NonNull VHHoDan holder, int position) {
        holder.setModel(getItem(position));
    }

    public void doSort(Comparator<TimeComparator.TimeShortable> comparable){
        Collections.sort(getmList(), comparable);
    }

}
