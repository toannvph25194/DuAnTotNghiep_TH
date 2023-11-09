package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.entity.Image;
import fpt.edu.duantn_th.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface ImageService {
    // show
    public List<Image> getAllimg();

    // delete
    Image deleteimage(UUID idimg);

    //add
    Image addimage(Image image);

    //update
    Image updateimage(Image image , UUID idimg);
}
