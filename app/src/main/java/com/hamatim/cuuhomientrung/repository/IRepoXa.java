package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.model.Tinh;
import com.hamatim.cuuhomientrung.model.Xa;

import java.util.List;

public interface IRepoXa {

    void all(CallBack<List<Xa>> callBack);

}
