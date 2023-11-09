package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.entity.ChucVu;
import fpt.edu.duantn_th.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    // show
    public List<MauSac> getAllmausac();

    // delete
    MauSac deletemausac(UUID idms);

    //add
    MauSac addmausac(MauSac ms);

    //update
    MauSac updatemausac(MauSac ms , UUID idms);

}
