package fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.DiaChiNDRepon;

import java.util.List;

public interface DiaChiNDService {

    // Hàm Load địa chỉ người dùng theo tên tài khoản
    List<DiaChiNDRepon> getAllDiaChiND(String tdaikhoan);
}
