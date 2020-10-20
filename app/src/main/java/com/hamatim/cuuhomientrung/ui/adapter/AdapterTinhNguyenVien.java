package com.hamatim.cuuhomientrung.ui.adapter;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.model.TinhNguyenVien;
import com.hamatim.cuuhomientrung.ui.viewholder.VHTinhNguyenVien;

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
        return R.layout.layout_item_tinhnguyenvien;
    }

    @Override
    public void onBindViewHolder(@NonNull VHTinhNguyenVien holder, int position) {
        holder.setModel(getItem(position));
    }

}
