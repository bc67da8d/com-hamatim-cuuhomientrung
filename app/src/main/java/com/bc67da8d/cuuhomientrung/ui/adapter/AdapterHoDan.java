package com.bc67da8d.cuuhomientrung.ui.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.HoDan;
import com.bc67da8d.cuuhomientrung.ui.viewholder.VHHoDan;

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

}
