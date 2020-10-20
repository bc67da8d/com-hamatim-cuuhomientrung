package com.bc67da8d.cuuhomientrung.repository;

import com.bc67da8d.cuuhomientrung.callback.CallBack;
import com.bc67da8d.cuuhomientrung.model.TinhNguyenVien;
import java.util.List;

public interface IRepoTinhNguyenVien {

    void all(CallBack<List<TinhNguyenVien>> callBack);

}
