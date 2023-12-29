package fpt.edu.duantn_th.controller;


import fpt.edu.duantn_th.dto.respon.MessageAddGioHang;
import fpt.edu.duantn_th.dto.respon.TimKiemIdGH;
import fpt.edu.duantn_th.entity.GioHang;
import fpt.edu.duantn_th.repository.GioHangRepository;
import fpt.edu.duantn_th.service.Impl.GioHangServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/gio-hang")
public class GioHangController {

    @Autowired
    GioHangServiceImpl gioHangService;

    //TODO tạo mới 1 giỏ hàng
    @PostMapping("/add")
    public ResponseEntity<?> addGH(GioHang gh , @RequestParam("idtk") UUID idtk){
        try {
            return ResponseEntity.ok(gioHangService.createGioHang(gh,idtk));
        }catch (EntityNotFoundException ex){
            // Trả về chuỗi JSON chứa thông báo lỗi và HTTP status 400 (Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Giỏ Hàng Đã Có Và Trạng Thái Bằng 1 !\"}");

        }
    }

    // TODO Tìm Kiếm IdGH theo IdTK và Trạng Thái GH
    @GetMapping("/tim-kiem/gio-hang")
    public ResponseEntity<?> finByIdGioHang(@RequestParam("idtk") UUID idtk){

        try {
            return ResponseEntity.ok(gioHangService.findByIdgiohang(idtk));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Không Tìm Thấy IdGH Hoặc Chưa Tạo!");
        }
    }

}
