package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.service.Impl.GioHangCTServiceImpl;
import fpt.edu.duantn_th.service.Impl.GioHangServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ghct")
public class GioHangCTController {

    @Autowired
    GioHangCTServiceImpl gioHangCTService;

    @Autowired
    GioHangServiceImpl gioHangService;


    // TODO Load on Giỏ Hàng Chi Tiết

    @GetMapping("/show")
    public ResponseEntity<?> getALLGHCT(@RequestParam("idgh") UUID idgh){
        return ResponseEntity.ok(gioHangCTService.getALlGHCT(idgh));
    }

    // TODO Thêm sản phẩm vào giỏ hàng ct
    @PostMapping("/add-san-pham")
    public ResponseEntity<?> addSPVaoGH(@RequestParam("idgiohang") UUID idgh , @RequestParam("idctsp") UUID idspct, @RequestParam("soluong") Long soluong){

        try {
            gioHangCTService.addSPVaoGioHangCT(idgh,idspct, soluong);
            return ResponseEntity.ok("Thêm sản phẩm vào giỏ hàng chi tiết thành công !");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Thêm sản phẩm vào giỏ hàng chi tiết không thành công !");
        }
    }

    // TODO update số lượng trong giỏ hàng ct
    @PutMapping("/update-so-luong")
    public ResponseEntity<?> updateSoLuong(@RequestParam("idghct") UUID idghct, @RequestParam("soluong") Long soluong){

        try {
            gioHangCTService.updateGHCT(idghct, soluong);
            return ResponseEntity.ok("Update số lượng thành công !");
        }catch (EntityNotFoundException ettnf){
            return ResponseEntity.badRequest().body("Update số lượng không thành công !");
        }
    }

    // TODO delete sản phẩm trong giỏ hàng chi tiết
    @DeleteMapping("/delete-san-pham")
    public ResponseEntity<?> deleteSPGHCT(@RequestParam("idghct") UUID idghct){
        try {
            gioHangCTService.deleteSPGHCT(idghct);
            return ResponseEntity.ok("delete giỏ hàng chi tiết thành công!");
        }catch (EntityNotFoundException ettnf){
            return ResponseEntity.badRequest().body("delete giỏ hàng chi tiết không thành công!");
        }
    }

    // TODO delete all sản phẩm trong giỏ hàng chi tiết
    @DeleteMapping("/delete-all-san-pham")
    public ResponseEntity<?> deleteALlSPGHCT(@RequestParam("idgiohang") UUID idgiohang){
        try {
            gioHangCTService.deleteALlSPGHCT(idgiohang);
            return ResponseEntity.ok("delete all giỏ hàng chi tiết thành công!");
        }catch (EntityNotFoundException ettnf){
            return ResponseEntity.badRequest().body("delete all giỏ hàng chi tiết không thành công!");
        }
    }

}
