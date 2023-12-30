package fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.UserThongTinNDRepon;

public interface UserThongTinNDService {

    // Tìm Kiếm thông tin người dùng qua taikhoan
    UserThongTinNDRepon finByTaiKhoan(String taikhoan);
}
