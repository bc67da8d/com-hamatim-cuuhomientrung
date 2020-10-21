package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.model.CuuHo;
import com.hamatim.cuuhomientrung.model.Tinh;

import java.util.List;

public interface IRepoTinh {

    void all(CallBack<List<Tinh>> callBack);

}
