package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.model.Huyen;
import com.hamatim.cuuhomientrung.model.Tinh;

import java.util.List;

public interface IRepoHuyen {

    void all(CallBack<List<Huyen>> callBack);

}
