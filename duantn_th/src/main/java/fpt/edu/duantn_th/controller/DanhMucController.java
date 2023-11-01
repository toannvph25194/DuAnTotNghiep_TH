package fpt.edu.duantn_th.controller;


import fpt.edu.duantn_th.entity.DanhMuc;
import fpt.edu.duantn_th.service.Impl.DanhMucServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/danh-muc")
public class DanhMucController {
    @Autowired
    DanhMucServiceImpl service;

    //api Load Table
    @GetMapping("/show")
    public ResponseEntity<?> getALlDanhMuc(){
        return ResponseEntity.ok(service.getAllDanhMuc());
    }

    @DeleteMapping("/delete/danh-muc/{iddanhmuc}")
    public ResponseEntity<?> deleteDanhMuc(@PathVariable("iddanhmuc") UUID iddm){
        return ResponseEntity.ok(service.deletedanhmuc(iddm));
    }

    @PutMapping("/update/danh-muc/{iddanhmuc}")
    public ResponseEntity<?> updateDanhMuc(@RequestBody DanhMuc dm , @PathVariable("iddanhmuc") UUID iddm){
        return ResponseEntity.ok(service.updatedanhmuc(dm,iddm));
    }

    @PostMapping("/add/danh-muc")
    public ResponseEntity<?> addDanhMuc(@RequestBody DanhMuc danhMuc){
        return ResponseEntity.ok(service.adddanhmuc(danhMuc));
    }
}
