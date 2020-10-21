package com.hamatim.cuuhomientrung.ui.viewholder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.hamatim.cuuhomientrung.R;
import com.hamatim.cuuhomientrung.callback.ViewCallBack;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.util.HelperFormat;

import static com.hamatim.cuuhomientrung.util.HelperFormat.getDateFormatedFromDateText;

public class VHCuuHo extends VHBase<CuuHo> {

    private TextView tvUpdateTime, tvStatus, tvName, tvPhone, tvNote;
    private ImageButton imbtEdit;
    private ViewCallBack<CuuHo> callBack;

    public VHCuuHo(@NonNull View itemView) {
        super(itemView);
        tvUpdateTime = itemView.findViewById(R.id.tvUpdateTime);
        tvStatus = itemView.findViewById(R.id.tvStatus);
        tvName = itemView.findViewById(R.id.tvName);
        tvPhone = itemView.findViewById(R.id.tvPhone);
        tvNote = itemView.findViewById(R.id.tvNote);
        imbtEdit = itemView.findViewById(R.id.imbtEdit);
        imbtEdit.setOnClickListener(view -> {
            if (getCallBack() != null){
                getCallBack().callback(view, getModel());
            }
        });
    }

    @Override
    public void notifyDataSetChanged() {
        if (getModel() != null){
            tvUpdateTime.setText(getDateFormatedFromDateText(getModel().getUpdateTime()));
            tvStatus.setText(HelperFormat.getCuuHoStatus(getModel().getStatus()));
            tvStatus.setBackgroundColor(HelperFormat.getCuuHoColor(getModel().getStatus()));
            tvName.setText(getModel().getName());
            tvPhone.setText(getModel().getPhone());
            tvNote.setText(getModel().getNote());
        }
    }

    public ViewCallBack<CuuHo> getCallBack() {
        return callBack;
    }

    public void setCallBack(ViewCallBack<CuuHo> callBack) {
        this.callBack = callBack;
    }

}
