package com.hamatim.cuuhomientrung.ui.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.callback.ViewCallBack;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.ui.viewholder.VHHoDan;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.util.Collections;
import java.util.Comparator;

public class AdapterHoDan extends AdapterBase<HoDan, VHHoDan> {

    private ViewCallBack<HoDan> viewCallBack;

    public AdapterHoDan(Context mContext) {
        super(mContext);
    }

    @Override
    protected VHHoDan onCreateViewHolder(View root) {
        VHHoDan vhHoDan = new VHHoDan(root);
        vhHoDan.setCallBack(getViewCallBack());
        return vhHoDan;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_item_hodan;
    }

    @Override
    public void onBindViewHolder(@NonNull VHHoDan holder, int position) {
        holder.setModel(getItem(position));
    }

    public ViewCallBack<HoDan> getViewCallBack() {
        return viewCallBack;
    }

    public void setViewCallBack(ViewCallBack<HoDan> viewCallBack) {
        this.viewCallBack = viewCallBack;
    }

}
