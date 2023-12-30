package fpt.edu.duantn_th.controller.mua_hang_online_controller.hoa_don_dang_nhap;

import fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_dang_nhap.DiaChiNDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/thong-tin")
public class DiaChiNDController {

    @Autowired
    DiaChiNDServiceImpl diaChiNDService;

    @GetMapping("/dia-chi/hien-thi")
    public ResponseEntity<?> getAllDiaChiND(Principal principal){
        String taikhoan = principal.getName();
        if (taikhoan != null) {
            return ResponseEntity.ok(diaChiNDService.getAllDiaChiND(taikhoan));
        } else {
            return ResponseEntity.badRequest().body("K tìm thấy địa chỉ người dùng !");
        }
    }

}
