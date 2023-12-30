package fpt.edu.duantn_th.controller.mua_hang_online_controller;


import fpt.edu.duantn_th.service.mua_hang_online_service_Impl.ChiTietSanPhamServiceImpl;
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

    // TODO Detail sanpham
    @GetMapping("/detail/san-pham")
    public ResponseEntity<?> detailSP(@RequestParam("idsp") UUID idsp){
        try {
            return ResponseEntity.ok(service.detailSP(idsp));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("No !");
        }
    }

    // TODO getALl sản phẩm mới tại trang CTSP
    @GetMapping("/get-all/san-pham-new")
    public ResponseEntity<?> getALlSPNewTaiCTSP(){
        try {
            return ResponseEntity.ok(service.getAllSPNewTaiCTSP());
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("No !");
        }
    }

    // TODO Load tổng số lượng sp detail
    @GetMapping("/get-all/tong-so-luong-san-pham")
    public ResponseEntity<?> tongSoLuongSP(@RequestParam("idsp") UUID idsp){
        try {
            return ResponseEntity.ok(service.loadTongSoLuongSP(idsp));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("No !");
        }
    }

    // TODO Detail size
    @GetMapping("/detail/size")
    public ResponseEntity<?> detailSize(@RequestParam("idsp") UUID idsp){
        try {
            return ResponseEntity.ok(service.detailSize(idsp));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("No !");
        }
    }

    // TODO Detail mausac
    @GetMapping("/detail/mau-sac")
    public ResponseEntity<?> detailMauSac(@RequestParam("idsp") UUID idsp){
        try {
            return ResponseEntity.ok(service.detailMauSac(idsp));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("No !");
        }
    }

    // TODO tìm kiếm size theo idsp và idmausac
    @GetMapping("/tim-kiem/size")
    public ResponseEntity<?> timKiemSizeAndChatLieu(@RequestParam("idsp") UUID idsp , @RequestParam("idmausac") UUID idmausac){
        try {
            return ResponseEntity.ok(service.timkiemSize(idsp,idmausac));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("No !");
        }
    }

    // TODO tìm kiếm màu sắc theo idsp và idsize
    @GetMapping("/tim-kiem/mau-sac")
    public ResponseEntity<?> timKiemMauSac(@RequestParam("idsp") UUID idsp , @RequestParam("idsize") UUID idsize){
        try {
            return ResponseEntity.ok(service.timkiemMauSac(idsp,idsize));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("No !");
        }
    }

    // TODO tìm kiếm IdCTSP theo idsp và idmausac và idsize
    @GetMapping("/tim-kiem/id-ctsp")
    public ResponseEntity<?> timKiemIdCTSP(@RequestParam("idsp") UUID idsp , @RequestParam("idmausac") UUID idmausac , @RequestParam("idsize") UUID idsize){
        try {
            return ResponseEntity.ok(service.timkiemIdCTSP(idsp, idmausac ,idsize));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("No !");
        }
    }

}
