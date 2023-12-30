package fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.request.mua_hang_online_request.dangnhap.Create_Khach_Hang_Dang_Nhap;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.dangnhap.MessageThanhToanDangNhapRepon;

import java.security.Principal;

public interface HoaDonDangNhapService {

    MessageThanhToanDangNhapRepon thanhToanDN(Create_Khach_Hang_Dang_Nhap khachHangDangNhap , Principal principal);
}
