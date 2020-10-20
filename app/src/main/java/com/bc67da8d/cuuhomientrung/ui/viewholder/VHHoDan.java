package com.bc67da8d.cuuhomientrung.ui.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bc67da8d.cuuhomientrung.R;
import com.bc67da8d.cuuhomientrung.model.HoDan;
import com.bc67da8d.cuuhomientrung.util.HelperFormat;

import static com.bc67da8d.cuuhomientrung.util.HelperFormat.getDateFormatedFromDateText;

public class VHHoDan extends VHBase<HoDan> {

    private TextView tvUpdateTime, tvStatus, tvName, tvPhone, tvNote;

    public VHHoDan(@NonNull View itemView) {
        super(itemView);
        tvUpdateTime = itemView.findViewById(R.id.tvUpdateTime);
        tvStatus = itemView.findViewById(R.id.tvStatus);
        tvName = itemView.findViewById(R.id.tvName);
        tvPhone = itemView.findViewById(R.id.tvPhone);
        tvNote = itemView.findViewById(R.id.tvNote);
    }

    @Override
    public void notifyDataSetChanged() {
        if (getModel() != null){
            tvUpdateTime.setText(getDateFormatedFromDateText(getModel().getUpdateTime()));
            tvStatus.setText(HelperFormat.getHoDanStatus(getModel().getStatus()));
            tvStatus.setBackgroundColor(HelperFormat.getHoDanColor(getModel().getStatus()));
            tvName.setText(getModel().getName());
            tvPhone.setText(getModel().getPhone());
            tvNote.setText(getModel().getNote());
        }
    }

}
