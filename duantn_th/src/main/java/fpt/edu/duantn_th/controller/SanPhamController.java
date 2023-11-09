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
    public ResponseEntity<?> getAllPTSanPham(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "9") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<SanPhamRepon> sanPhamPage = service.getALlPTSPRepon(pageable);
        return new ResponseEntity<>(sanPhamPage, HttpStatus.OK);
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

    // TODO getALl sp Nữ lên trang chủ
    @GetMapping("/show-new")
    public ResponseEntity<?> getAllSPNew(){
        return ResponseEntity.ok(service.getALlSPNewRepon());
    }

    // TODO detail sp
    @GetMapping("/detail-sp/{idsp}")
    public ResponseEntity<?> getByIdSP(@PathVariable("idsp") UUID idsp){
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
