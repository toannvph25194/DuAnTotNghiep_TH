package fpt.edu.duantn_th.controller.mua_hang_online_controller.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.request.mua_hang_online_request.dangnhap.Create_Khach_Hang_Dang_Nhap;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.dangnhap.MessageThanhToanDangNhapRepon;
import fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_dang_nhap.HoaDonDangNhapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonControllerDangNhap {

    @Autowired
    HoaDonDangNhapServiceImpl thanhToanDangNhapService;

    @PostMapping("/thanh-toan/dang-nhap")
    public MessageThanhToanDangNhapRepon thanhToanDangNhap(@RequestBody Create_Khach_Hang_Dang_Nhap create_khach_hang_dang_nhap , Principal principal) {
            return thanhToanDangNhapService.thanhToanDN(create_khach_hang_dang_nhap , principal);
    }


}
