package fpt.edu.duantn_th.controller.not_login;

import fpt.edu.duantn_th.dto.request.not_login.Create_Khach_Hang_Not_login;
import fpt.edu.duantn_th.dto.respon.not_login.MessageThanhToanRepon_not_login;
import fpt.edu.duantn_th.service.Impl.not_login.HoaDonService_Not_Login_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonController_Not_Login {

    @Autowired
    HoaDonService_Not_Login_Impl donHangServiceNotLogin;

    // Endpoint để tạo hóa đơn và thanh toán khi khách hàng không đăng nhập
    @PostMapping("/thanh-toan")
    public MessageThanhToanRepon_not_login thanhToanKhongDangNhap(
            @RequestBody Create_Khach_Hang_Not_login createKhachRequest_not_login
    ) {
        return donHangServiceNotLogin.thanhToanKhongDangNhap(createKhachRequest_not_login);
    }

}
