package fpt.edu.duantn_th.controller;


import fpt.edu.duantn_th.entity.GioHang;
import fpt.edu.duantn_th.repository.GioHangRepository;
import fpt.edu.duantn_th.service.Impl.GioHangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/gio-hang")
public class GioHangController {

    @Autowired
    GioHangServiceImpl gioHangService;

    //TODO tạo mới 1 giỏ hàng
    @PostMapping("/add")
    public ResponseEntity<?> addGH(GioHang gh , @RequestParam("idtk") UUID idtk){
        try {
            return ResponseEntity.ok(gioHangService.createGioHang(gh,idtk));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(null);
        }
    }

}
