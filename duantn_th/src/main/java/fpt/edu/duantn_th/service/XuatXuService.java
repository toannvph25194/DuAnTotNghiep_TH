package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.entity.XuatXu;

import java.util.List;
import java.util.UUID;

public interface XuatXuService {
    public List<XuatXu> getAllXuatXu();

    // delete
    XuatXu deletexuatxu(UUID idxuatxu);

    //add
    XuatXu addxuatxu(XuatXu xx);

    //update
    XuatXu updatexuatxu(XuatXu xx , UUID idxuatxu);
}
