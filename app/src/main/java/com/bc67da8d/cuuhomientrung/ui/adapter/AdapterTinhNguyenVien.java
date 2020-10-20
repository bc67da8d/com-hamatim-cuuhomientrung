package com.bc67da8d.cuuhomientrung.ui.adapter;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.TinhNguyenVien;
import com.bc67da8d.cuuhomientrung.ui.viewholder.VHTinhNguyenVien;

public class AdapterTinhNguyenVien extends AdapterBase<TinhNguyenVien, VHTinhNguyenVien> {

    public AdapterTinhNguyenVien(Context mContext) {
        super(mContext);
    }

    @Override
    protected VHTinhNguyenVien onCreateViewHolder(View root) {
        return new VHTinhNguyenVien(root);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_item_general;
    }

    @Override
    public void onBindViewHolder(@NonNull VHTinhNguyenVien holder, int position) {

    }

}
