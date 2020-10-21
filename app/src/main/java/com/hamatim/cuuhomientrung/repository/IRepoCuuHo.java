package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.model.DTO;
import com.hamatim.cuuhomientrung.model.HoDan;

import java.util.List;

public interface IRepoCuuHo {

    void all(CallBack<List<CuuHo>> callBack);
    void create(CallBack<DTO<CuuHo>> callBack, CuuHo model);
    void update(CallBack<DTO<CuuHo>> callBack, CuuHo model);
}
