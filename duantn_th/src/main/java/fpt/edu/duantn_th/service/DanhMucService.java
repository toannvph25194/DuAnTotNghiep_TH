package fpt.edu.duantn_th.service;


import fpt.edu.duantn_th.entity.DanhMuc;

import java.util.List;
import java.util.UUID;

public interface DanhMucService {

    List<DanhMuc> getAllDanhMuc();

    // delete
    DanhMuc deletedanhmuc(UUID iddm);

    //add
    DanhMuc adddanhmuc(DanhMuc dm);

    //update
    DanhMuc updatedanhmuc(DanhMuc dm , UUID iddm);
}
