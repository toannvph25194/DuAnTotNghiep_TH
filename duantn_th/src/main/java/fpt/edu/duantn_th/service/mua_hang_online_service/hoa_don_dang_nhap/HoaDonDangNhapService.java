package fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.request.mua_hang_online_request.dangnhap.Create_Hinh_Thuc_TT_DangNhap;
import fpt.edu.duantn_th.dto.request.mua_hang_online_request.dangnhap.Create_Khach_Hang_Dang_Nhap;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.dangnhap.MessageThanhToanDangNhapRepon;
import fpt.edu.duantn_th.entity.HinhThucThanhToan;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.UUID;

public interface HoaDonDangNhapService {

    // Tạo mới hóa đơn
    MessageThanhToanDangNhapRepon thanhToanDN(Create_Khach_Hang_Dang_Nhap khachHangDangNhap , Principal principal);

    // Tạo mới hình thức thanh toán
    HinhThucThanhToan hinhThucTT(UUID idhoadon, Double soTienTra, String maGiaoDinh);
}
