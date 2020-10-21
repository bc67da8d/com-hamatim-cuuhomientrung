package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.model.DTO;
import com.hamatim.cuuhomientrung.model.HoDan;
import java.util.List;

public interface IRepoHoDan {

    void all(CallBack<List<HoDan>> callBack);
    void create(CallBack<DTO<HoDan>> callBack, HoDan hoDan);
    void update(CallBack<DTO<HoDan>> callBack, HoDan hoDan);

}
