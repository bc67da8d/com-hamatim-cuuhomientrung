package com.bc67da8d.cuuhomientrung.util;

import android.content.res.Resources;

import com.bc67da8d.cuuhomientrung.MainApplication;
import com.bc67da8d.cuuhomientrung.R;

import org.joda.time.DateTime;
import org.joda.time.Instant;

public class HelperFormat {

    public static String getCuuHoStatus(int status) {
        switch (status) {
            case 1:
                return "Sẵn sàng";
            case 2:
                return "Không gọi được";
            case 3:
                return "Đang cứu hộ";
            case 4:
                return "Đang nghỉ";
            default:
                return "Chưa xác minh";
        }
    }

    public static String getHoDanStatus(int status) {
        switch (status) {
            case 1:
                return "Cần ứng cứu gấp";
            case 2:
                return "Không gọi được";
            case 3:
                return "Đã được cứu";
            case 4:
                return "Gặp nạn";
            default:
                return "Chưa xác minh";
        }
    }

    public static int getCuuHoColor(int status) {
        switch (status) {
            case 1:
                return getRes().getColor(R.color.green_A700);
            case 2:
                return getRes().getColor(R.color.red_A700);
            case 3:
                return getRes().getColor(R.color.orange_A700);
            case 4:
                return getRes().getColor(R.color.black);
            default:
                return getRes().getColor(R.color.light_blue_A700);
        }
    }

    public static int getHoDanColor(int status) {
        switch (status) {
            case 1:
                return getRes().getColor(R.color.red_A700);
            case 2:
                return getRes().getColor(R.color.orange_A700);
            case 3:
                return getRes().getColor(R.color.green_A700);
            case 4:
                return getRes().getColor(R.color.black);
            default:
                return getRes().getColor(R.color.light_blue_A700);
        }
    }

    public static String getDateFormatedFromDateText(String date){
        DateTime dt = Instant.parse(date).toDateTime();
        return dt.toString("HH:mm dd-MM-YYYY");
    }

    private static Resources getRes(){
        return MainApplication.getInstance().getResources();
    }

}
