package fpt.edu.duantn_th.controller;


import fpt.edu.duantn_th.entity.SanPham;
import fpt.edu.duantn_th.service.Impl.SanPhamServiceImpl;
import jdk.jfr.Registered;
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

    // TODO getALl sp lên trang chủ
    @GetMapping("/show")
    public ResponseEntity<?> getAllSPCT(){
        return ResponseEntity.ok(service.getALlSPRepon());
    }

    // TODO getALl sp Nam lên trang chủ
    @GetMapping("/show-nam")
    public ResponseEntity<?> getAllSPCTNam(){
        return ResponseEntity.ok(service.getALlSPNamRepon());
    }

    // TODO getALl sp Nữ lên trang chủ
    @GetMapping("/show-nu")
    public ResponseEntity<?> getAllSPCTNu(){
        return ResponseEntity.ok(service.getALlSPNuRepon());
    }

    // TODO detail sp
    @GetMapping("/detail-sp/{idsp}")
    public ResponseEntity<?> getByIdCTSP(@PathVariable("idsp") UUID idsp){
        return ResponseEntity.ok(service.getByIdSP(idsp));
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
