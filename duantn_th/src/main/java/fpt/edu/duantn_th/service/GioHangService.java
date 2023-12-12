package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.entity.GioHang;

import java.util.UUID;

public interface GioHangService {

    // Tạo giỏ hàng
    GioHang createGioHang(GioHang gh, UUID idtk);

}
