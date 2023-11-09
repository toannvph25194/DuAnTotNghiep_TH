package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.entity.ChucVu;
import fpt.edu.duantn_th.entity.MauSac;
import fpt.edu.duantn_th.service.Impl.MauSacServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Controller
@RequestMapping("/api/mau-sac")
public class MauSacController {
    @Autowired
    MauSacServiceimpl mauSacServiceimpl;

    @GetMapping("/show")
    public ResponseEntity<?> getAllMauSac(){
        return ResponseEntity.ok(mauSacServiceimpl.getAllmausac());
    }

    @DeleteMapping("/delete/mau-sac/{idmausac}")
    public ResponseEntity<?> deletemausac(@PathVariable("idmausac") UUID idms){
        return ResponseEntity.ok(mauSacServiceimpl.deletemausac(idms));
    }

    @PutMapping("/update/mau-sac/{idmausac}")
    public ResponseEntity<?> updatemausac(@RequestBody MauSac ms , @PathVariable("idmausac") UUID idms){
        return ResponseEntity.ok(mauSacServiceimpl.updatemausac(ms,idms));
    }

    @PostMapping("/add/mau-sac")
    public ResponseEntity<?> addmausac(@RequestBody MauSac ms){
        return ResponseEntity.ok(mauSacServiceimpl.addmausac(ms));
    }
}
