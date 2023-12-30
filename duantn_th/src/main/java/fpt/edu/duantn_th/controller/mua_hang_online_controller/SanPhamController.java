package fpt.edu.duantn_th.controller.mua_hang_online_controller;


import fpt.edu.duantn_th.service.mua_hang_online_service_Impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/san-pham")
public class SanPhamController {

    @Autowired
    SanPhamServiceImpl service;

    // TODO getALl PT sp lên trang chủ
    @GetMapping("/show-phan-trang")
    public ResponseEntity<?> getAllPTSanPham( @RequestParam(defaultValue = "0" ,value = "page") Integer page) {
        return ResponseEntity.ok(service.getALlPTSPRepon(page));
    }


    // TODO getALl sp lên trang chủ
    @GetMapping("/show")
    public ResponseEntity<?> getAllSP(){
        return ResponseEntity.ok(service.getALlSPRepon());
    }

    // TODO getALl sp Nam lên trang chủ
    @GetMapping("/show-nam")
    public ResponseEntity<?> getAllSPNam(){
        return ResponseEntity.ok(service.getALlSPNamRepon());
    }

    // TODO getALl sp Nữ lên trang chủ
    @GetMapping("/show-nu")
    public ResponseEntity<?> getAllSPNu(){
        return ResponseEntity.ok(service.getALlSPNuRepon());
    }

    // TODO getALl sp mới lên trang chủ
    @GetMapping("/show-new")
    public ResponseEntity<?> getAllSPNew(){
        return ResponseEntity.ok(service.getALlSPNewRepon());
    }

    // TODO Lọc danh mục sp
    @GetMapping("/loc-danh-muc/{iddanhmuc}")
    public ResponseEntity<?> findByIdDanhMuc(@PathVariable("iddanhmuc") UUID iddanhmuc){
        return ResponseEntity.ok(service.findByIdDM(iddanhmuc));
    }

    // TODO Lọc size sp
    @GetMapping("/loc-size/{idsize}")
    public ResponseEntity<?> findByIdSize(@PathVariable("idsize") UUID idsize){
        return ResponseEntity.ok(service.findByIdSize(idsize));
    }

    // TODO Tìm kiếm theo tên sp
    @GetMapping("/loc-tensp/{tensp}")
    public ResponseEntity<?> findByNameSP(@PathVariable("tensp") String tensp){
        return ResponseEntity.ok(service.findByNameSP(tensp));
    }
}
