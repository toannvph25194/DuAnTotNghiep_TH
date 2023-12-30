package fpt.edu.duantn_th.service.mua_hang_online_service;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.CheckoutRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.GioHangCTRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.TongSoTienRepon;
import fpt.edu.duantn_th.entity.GioHangChiTiet;

import java.util.List;
import java.util.UUID;

public interface GioHangCTService {

    // Get on ghct
    List<GioHangCTRepon> getALlGHCT(UUID idgiohang);

    // Add sản phẩm vào giỏ hàng
    void addSPVaoGioHangCT(UUID idgiohang , UUID idctsp , Integer soluong );

    // Cập Nhật Số Lượng Giỏ Hàng CT
    GioHangChiTiet updateGHCT(UUID idghct , Integer soluong);

    // Delete sản phẩm trong giỏ hàng chi tiết
    GioHangChiTiet deleteSPGHCT(UUID idghct);

    // Delete All sản phẩm trong giỏ hàng chi tiết
    public void deleteALlSPGHCT(UUID idgiohang);

    // get All checkout
    List<CheckoutRepon> getAllTongTien(UUID idgiohang);

    // get All checkout
    List<TongSoTienRepon> getTongSoTien(UUID idgiohang);
}
