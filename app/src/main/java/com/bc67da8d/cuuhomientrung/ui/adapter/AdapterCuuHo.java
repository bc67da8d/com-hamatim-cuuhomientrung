package com.bc67da8d.cuuhomientrung.ui.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.CuuHo;
import com.bc67da8d.cuuhomientrung.model.HoDan;
import com.bc67da8d.cuuhomientrung.ui.viewholder.VHCuuHo;
import com.bc67da8d.cuuhomientrung.ui.viewholder.VHHoDan;

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
        return R.layout.layout_item_general;
    }

    @Override
    public void onBindViewHolder(@NonNull VHCuuHo holder, int position) {

    }

}
