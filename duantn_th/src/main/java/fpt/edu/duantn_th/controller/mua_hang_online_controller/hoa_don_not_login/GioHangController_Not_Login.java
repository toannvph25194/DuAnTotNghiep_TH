package fpt.edu.duantn_th.controller.mua_hang_online_controller.hoa_don_not_login;

import fpt.edu.duantn_th.entity.GioHang;
import fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_not_login.GioHangServiceNot_login_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gio-hang")
public class GioHangController_Not_Login {

    @Autowired
    GioHangServiceNot_login_Impl gioHangServiceNot_login;

    @PostMapping("/khong-dang-nhap")
    public ResponseEntity<?> taoGioHangNotLogin(GioHang gh){
        return ResponseEntity.ok(gioHangServiceNot_login.createGioHang(gh));
    }
}
