package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.dto.respon.MessageAddGioHangCT;
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
    public ResponseEntity<?> getALLGHCT(@RequestParam("idgiohang") UUID idgh){
        return ResponseEntity.ok(gioHangCTService.getALlGHCT(idgh));
    }

    // TODO Load all checkout tổng tiền
    @GetMapping("/show-tong-tien")
    public ResponseEntity<?> getALLTongTien(@RequestParam("idgiohang") UUID idgiohang){
        return ResponseEntity.ok(gioHangCTService.getAllTongTien(idgiohang));
    }

    // TODO Load tổng số tiền
    @GetMapping("/show-tong-so-tien")
    public ResponseEntity<?> getALLTongSoTien(@RequestParam("idgiohang") UUID idgiohang){
        return ResponseEntity.ok(gioHangCTService.getTongSoTien(idgiohang));
    }


    // TODO Thêm sản phẩm vào giỏ hàng ct
    @PostMapping("/add-san-pham")
    public ResponseEntity<?> addSPVaoGH(@RequestParam("idgiohang") UUID idgh , @RequestParam("idctsp") UUID idspct, @RequestParam("soluong") Integer soluong){

        try {
            System.out.println("ABC :" + idgh + idspct + soluong);
            gioHangCTService.addSPVaoGioHangCT(idgh,idspct, soluong);
            return ResponseEntity.ok(new MessageAddGioHangCT("Thêm sản phẩm vào giỏ hàng chi tiết thành công !"));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageAddGioHangCT ("Không thêm được sp vào giỏ hàng !"));
        }
    }

    // TODO update số lượng trong giỏ hàng ct
    @PutMapping("/update-so-luong")
    public ResponseEntity<?> updateSoLuong(@RequestParam("idghct") UUID idghct, @RequestParam("soluong") Integer soluong){

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
