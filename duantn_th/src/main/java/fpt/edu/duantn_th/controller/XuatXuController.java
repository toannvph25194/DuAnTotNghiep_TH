package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.entity.XuatXu;
import fpt.edu.duantn_th.service.Impl.XuatXuServiceIpml;
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
@RequestMapping("/api/xuat-xu")
public class XuatXuController {
    @Autowired
    XuatXuServiceIpml service;

    //api Load Table
    @GetMapping("/show")
    public ResponseEntity<?> getAllXuatXu(){
        return ResponseEntity.ok(service.getAllXuatXu());
    }

    @DeleteMapping("/delete/xuat-xu/{idxuatxu}")
    public ResponseEntity<?> deleteXuatXu(@PathVariable("idxuatxu")UUID idxuatxu){
        return ResponseEntity.ok(service.deletexuatxu(idxuatxu));
    }

    @PutMapping("/update/xuat-xu/{idxuatxu}")
    public ResponseEntity<?> updateXuatXu(@RequestBody XuatXu cv , @PathVariable("idxuatxu") UUID idxuatxu){
        return ResponseEntity.ok(service.updatexuatxu(cv,idxuatxu));
    }

    @PostMapping("/add/xuat-xu")
    public ResponseEntity<?> addXuatXu(@RequestBody XuatXu cv){
        return ResponseEntity.ok(service.addxuatxu(cv));
    }
}
