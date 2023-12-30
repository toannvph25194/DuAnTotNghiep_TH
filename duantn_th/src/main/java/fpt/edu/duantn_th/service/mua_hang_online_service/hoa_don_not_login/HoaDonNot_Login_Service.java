package fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_not_login;

import fpt.edu.duantn_th.dto.request.mua_hang_online_request.not_login.Create_Khach_Hang_Not_login;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.not_login.MessageThanhToanRepon_not_login;

public interface HoaDonNot_Login_Service {
    MessageThanhToanRepon_not_login thanhToanKhongDangNhap(Create_Khach_Hang_Not_login create_khach_hang_not_login);
}
