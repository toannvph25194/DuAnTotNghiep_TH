package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.entity.MauSac;
import fpt.edu.duantn_th.entity.Size;
import fpt.edu.duantn_th.service.Impl.SizeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/size")
public class SizeController {
    @Autowired
    SizeServiceimpl sizeServiceimpl;


    @GetMapping("/show")
    public ResponseEntity<?> getAllsize(){
        return ResponseEntity.ok(sizeServiceimpl.getAllsize());
    }

    @DeleteMapping("/delete/size/{idsz}")
    public ResponseEntity<?> deletesize(@PathVariable("idsz") UUID idsz){
        return ResponseEntity.ok(sizeServiceimpl.deletesize(idsz));
    }

    @PutMapping("/update/size/{idsz}")
    public ResponseEntity<?> updatesize(@RequestBody Size sz , @PathVariable("idsz") UUID idsz){
        return ResponseEntity.ok(sizeServiceimpl.updatesize(sz,idsz));
    }

    @PostMapping("/add/size")
    public ResponseEntity<?> addsize(@RequestBody Size sz){
        return ResponseEntity.ok(sizeServiceimpl.addsize(sz));
    }
}
