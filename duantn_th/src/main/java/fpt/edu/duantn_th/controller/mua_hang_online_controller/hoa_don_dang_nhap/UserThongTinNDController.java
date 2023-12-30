package fpt.edu.duantn_th.controller.mua_hang_online_controller.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.UserThongTinNDRepon;
import fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_dang_nhap.UserThongTinNDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/thong-tin")
public class UserThongTinNDController {

    @Autowired
    UserThongTinNDServiceImpl userThongTinNDService;

    @GetMapping("/tim-kiem/nguoi-dung")
    public ResponseEntity<UserThongTinNDRepon> getTimKiemTTND(Principal principal) {
        String taikhoan = principal.getName();

        UserThongTinNDRepon userThongTinND = userThongTinNDService.finByTaiKhoan(taikhoan);

        if (userThongTinND != null) {
            return new ResponseEntity<>(userThongTinND, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
