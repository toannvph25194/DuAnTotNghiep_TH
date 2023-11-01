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
}
