package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.dto.respon.GioHangCTRepon;
import fpt.edu.duantn_th.entity.GioHang;
import fpt.edu.duantn_th.entity.GioHangChiTiet;

import java.util.List;
import java.util.UUID;

public interface GioHangCTService {

    // Get on ghct
    List<GioHangCTRepon> getALlGHCT(UUID idgh);

    // Add sản phẩm vào giỏ hàng
    void addSPVaoGioHangCT( UUID idgiohang , UUID idctsp , Long soluong );

    // Cập Nhật Số Lượng Giỏ Hàng CT
    GioHangChiTiet updateGHCT(UUID idghct , Long soluong);

    // Delete sản phẩm trong giỏ hàng chi tiết
    GioHangChiTiet deleteSPGHCT(UUID idghct);

    // Delete All sản phẩm trong giỏ hàng chi tiết
    public void deleteALlSPGHCT(UUID idgiohang);

}
