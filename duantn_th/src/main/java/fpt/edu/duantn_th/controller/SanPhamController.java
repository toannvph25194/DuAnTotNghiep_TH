package fpt.edu.duantn_th.controller;


import fpt.edu.duantn_th.dto.respon.SanPhamRepon;
import fpt.edu.duantn_th.entity.SanPham;
import fpt.edu.duantn_th.service.Impl.SanPhamServiceImpl;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
