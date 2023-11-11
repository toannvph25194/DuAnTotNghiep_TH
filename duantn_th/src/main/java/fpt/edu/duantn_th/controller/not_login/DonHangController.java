package fpt.edu.duantn_th.controller.not_login;

import fpt.edu.duantn_th.dto.request.not_login.Create_Khach_Hang_Not_login;
import fpt.edu.duantn_th.dto.respon.not_login.MessageThanhToanRepon_not_login;
import fpt.edu.duantn_th.service.Impl.DonHangServiceNotLoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hoa-don")
public class DonHangController {

    @Autowired
    DonHangServiceNotLoginImpl donHangServiceNotLogin;

    // Endpoint để tạo hóa đơn và thanh toán khi khách hàng không đăng nhập
    @PostMapping("/thanh-toan")
    public MessageThanhToanRepon_not_login thanhToanKhongDangNhap(
            @RequestBody Create_Khach_Hang_Not_login createKhachRequest_not_login
    ) {
        return donHangServiceNotLogin.thanhToanKhongDangNhap(createKhachRequest_not_login);
    }

}
