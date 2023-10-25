package fpt.edu.duantn_th.controller;


import fpt.edu.duantn_th.service.Impl.ChiTietSanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ctsp")
public class ChiTietSanPhamController {

    @Autowired
    ChiTietSanPhamServiceImpl service;

    // TODO getALl ctsp
    @GetMapping("/show")
    public ResponseEntity<?> getAllSPCT(){
        return ResponseEntity.ok(service.getALlCTSPRepon());
    }

    // TODO detail ctsp
    @GetMapping("/detail-ctsp/{idctsp}")
    public ResponseEntity<?> getByIdCTSP(@PathVariable("idctsp") UUID idctsp){
        return ResponseEntity.ok(service.getByIdCTSP(idctsp));
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
