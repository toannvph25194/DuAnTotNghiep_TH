package fpt.edu.duantn_th.controller.mua_hang_online_controller;


import fpt.edu.duantn_th.service.mua_hang_online_service_Impl.VouCherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voucher")
public class VouCherController {

    @Autowired
    VouCherServiceImpl vouCherService;

    @GetMapping("/hien-thi")
    public ResponseEntity<?> getALlVouCher(){
        return ResponseEntity.ok(vouCherService.getALlVouCher());
    }
}
