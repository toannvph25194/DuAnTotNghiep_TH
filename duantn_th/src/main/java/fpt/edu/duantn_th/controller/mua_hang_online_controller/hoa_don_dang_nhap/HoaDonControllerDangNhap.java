package fpt.edu.duantn_th.controller.mua_hang_online_controller.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.request.mua_hang_online_request.dangnhap.Create_Hinh_Thuc_TT_DangNhap;
import fpt.edu.duantn_th.dto.request.mua_hang_online_request.dangnhap.Create_Khach_Hang_Dang_Nhap;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.dangnhap.MessageThanhToanDangNhapRepon;
import fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_dang_nhap.HoaDonDangNhapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonControllerDangNhap {

    @Autowired
    HoaDonDangNhapServiceImpl thanhToanDangNhapService;

    @PostMapping("/thanh-toan/dang-nhap")
    public MessageThanhToanDangNhapRepon thanhToanDangNhap(@RequestBody Create_Khach_Hang_Dang_Nhap create_khach_hang_dang_nhap , Principal principal) {
            return thanhToanDangNhapService.thanhToanDN(create_khach_hang_dang_nhap , principal);
    }

    @PostMapping("/hinh-thuc-tt/vn-pay")
    public ResponseEntity<?> hinhThucTTVNPay(
            @RequestParam(name = "idhoadon") UUID idhoadon,
            @RequestParam("sotientra") Double sotientra,
            @RequestParam("magiaodinh") String magiaodinh) {
        return ResponseEntity.ok(thanhToanDangNhapService.hinhThucTT(idhoadon,sotientra,magiaodinh));
    }


}
