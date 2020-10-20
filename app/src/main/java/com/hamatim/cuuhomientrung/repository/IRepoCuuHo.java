package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.model.CuuHo;

import java.util.List;

public interface IRepoCuuHo {

    void all(CallBack<List<CuuHo>> callBack);

}
