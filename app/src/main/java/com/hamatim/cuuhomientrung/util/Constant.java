package com.hamatim.cuuhomientrung.util;

public class Constant {

    public static String BASE_URL = "https://cuuhomientrung.info/api/app/";

    public static final String[] HODAN_STATUS_LIST = {
            "Chưa xác minh",
            "Cần ứng cứu gấp",
            "Không gọi được",
            "Đã được cứu",
            "Gặp nạn"
    };

    public static enum STATE {
        SUCCESS,
        FAIL,
        UNKNOWN
    }

    public enum EVENT_TYPE {
        CREATE_HODAN,
        UPDATE_HODAN, UNKNOWN
    }
}
