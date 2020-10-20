package com.bc67da8d.cuuhomientrung.repository;

import com.bc67da8d.cuuhomientrung.callback.CallBack;
import com.bc67da8d.cuuhomientrung.model.HoDan;
import java.util.List;

public interface IRepoHoDan {

    void all(CallBack<List<HoDan>> callBack);

}
