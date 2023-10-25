package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.entity.ChucVu;

import java.util.List;

public interface ChucVuService {

    // show CV
    public List<ChucVu> getAllchucvu();

    // delete CV
    ChucVu deletechucvu(Long idcv);

    //add CV
    ChucVu addchucvu(ChucVu cv);

    //update CV
    ChucVu updatechucvu(ChucVu cv , Long idcv);

}
