package com.hamatim.cuuhomientrung.repository;

import com.hamatim.cuuhomientrung.callback.CallBack;
import com.hamatim.cuuhomientrung.model.TinhNguyenVien;
import java.util.List;

public interface IRepoTinhNguyenVien {

    void all(CallBack<List<TinhNguyenVien>> callBack);

}
