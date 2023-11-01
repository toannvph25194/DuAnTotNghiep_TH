package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.entity.ThuongHieu;

import java.util.List;
import java.util.UUID;

public interface ThuongHieuService {
    public List<ThuongHieu> getAllThuongHieu();

    // delete
    ThuongHieu deletethuonghieu(UUID idthuonghieu);

    //add
    ThuongHieu addthuonghieu(ThuongHieu th);

    //update
    ThuongHieu updatethuonghieu(ThuongHieu th , UUID idthuonghieu);
}
