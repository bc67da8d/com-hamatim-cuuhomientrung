package com.hamatim.cuuhomientrung.ui.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.ui.viewholder.VHCuuHo;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.util.Collections;
import java.util.Comparator;

public class AdapterCuuHo extends AdapterBase<CuuHo, VHCuuHo> {

    public AdapterCuuHo(Context mContext) {
        super(mContext);
    }

    @Override
    protected VHCuuHo onCreateViewHolder(View root) {
        return new VHCuuHo(root);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_item_cuuho;
    }

    @Override
    public void onBindViewHolder(@NonNull VHCuuHo holder, int position) {
        holder.setModel(getItem(position));
    }

}
