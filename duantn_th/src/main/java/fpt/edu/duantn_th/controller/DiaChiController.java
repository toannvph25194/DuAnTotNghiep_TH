package fpt.edu.duantn_th.controller;


import fpt.edu.duantn_th.service.Impl.DiaChiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/dia-chi")
public class DiaChiController {

    @Autowired
    DiaChiServiceImpl service;

    //api Load Table
    @GetMapping("/show")
    public ResponseEntity<?> getALlDiaChi(){
        return ResponseEntity.ok(service.getALLDiaChi());
    }
}
