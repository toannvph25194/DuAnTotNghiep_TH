package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.entity.ThuongHieu;
import fpt.edu.duantn_th.service.Impl.ThuongHieuServiceImpl;
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
@RequestMapping("/api/thuong-hieu")
public class ThuongHieuController {
    @Autowired
    ThuongHieuServiceImpl service;

    //api Load Table
    @GetMapping("/show")
    public ResponseEntity<?> getAllThuongHieu(){
        return ResponseEntity.ok(service.getAllThuongHieu());
    }

    @DeleteMapping("/delete/thuong-hieu/{idthuonghieu}")
    public ResponseEntity<?> deleteThuongHieu(@PathVariable("idthuonghieu") UUID idthuonghieu){
        return ResponseEntity.ok(service.deletethuonghieu(idthuonghieu));
    }

    @PutMapping("/update/thuong-hieu/{idthuonghieu}")
    public ResponseEntity<?> updateThuongHieu(@RequestBody ThuongHieu thuongHieu , @PathVariable("idthuonghieu") UUID idthuonghieu){
        return ResponseEntity.ok(service.updatethuonghieu(thuongHieu,idthuonghieu));
    }

    @PostMapping("/add/thuong-hieu")
    public ResponseEntity<?> addThuongHieu(@RequestBody ThuongHieu thuongHieu){
        return ResponseEntity.ok(service.addthuonghieu(thuongHieu));
    }
}
