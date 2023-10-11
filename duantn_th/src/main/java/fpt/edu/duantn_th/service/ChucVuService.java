package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.entity.ChucVu;

import java.util.List;

public interface ChucVuService {

    // show
    public List<ChucVu> getAllchucvu();

    // delete
    ChucVu deletechucvu(Long idcv);

    //add
    ChucVu addchucvu(ChucVu cv);

    //update
    ChucVu updatechucvu(ChucVu cv , Long idcv);

}
