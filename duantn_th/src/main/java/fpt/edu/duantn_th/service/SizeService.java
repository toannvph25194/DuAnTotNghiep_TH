package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.entity.MauSac;
import fpt.edu.duantn_th.entity.Size;

import java.util.List;
import java.util.UUID;

public interface SizeService {
    // show
    public List<Size> getAllsize();

    // delete
    Size deletesize(UUID idsz);

    //add
    Size addsize(Size sz);

    //update
    Size updatesize(Size sz , UUID idsz);

}
