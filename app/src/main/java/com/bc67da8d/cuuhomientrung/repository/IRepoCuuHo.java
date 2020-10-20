package com.bc67da8d.cuuhomientrung.repository;

import com.bc67da8d.cuuhomientrung.callback.CallBack;
import com.bc67da8d.cuuhomientrung.model.CuuHo;

import java.util.List;

public interface IRepoCuuHo {

    void all(CallBack<List<CuuHo>> callBack);

}
