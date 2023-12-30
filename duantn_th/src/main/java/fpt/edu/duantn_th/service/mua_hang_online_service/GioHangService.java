package fpt.edu.duantn_th.service.mua_hang_online_service;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.TimKiemIdGH;
import fpt.edu.duantn_th.entity.GioHang;

import java.util.UUID;

public interface GioHangService {

    // Tạo giỏ hàng
    GioHang createGioHang(GioHang gh, UUID idtk);

    // Tìm kiếm idgh
    TimKiemIdGH findByIdgiohang(UUID idtk);
}
