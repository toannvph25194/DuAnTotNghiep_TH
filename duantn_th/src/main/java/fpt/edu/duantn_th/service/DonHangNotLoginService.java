package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.dto.request.not_login.Create_Khach_Hang_Not_login;
import fpt.edu.duantn_th.dto.respon.not_login.MessageThanhToanRepon_not_login;

public interface DonHangNotLoginService {
    MessageThanhToanRepon_not_login thanhToanKhongDangNhap(Create_Khach_Hang_Not_login create_khach_hang_not_login);
}
