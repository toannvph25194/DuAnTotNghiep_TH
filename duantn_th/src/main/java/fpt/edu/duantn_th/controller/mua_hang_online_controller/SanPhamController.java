package fpt.edu.duantn_th.controller.mua_hang_online_controller;


import fpt.edu.duantn_th.service.mua_hang_online_service_Impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/san-pham")
public class SanPhamController {

    @Autowired
    SanPhamServiceImpl service;

    // TODO getALl PT sp lên shop
    @GetMapping("/show-phan-trang")
    public ResponseEntity<?> getAllPTSanPham( @RequestParam(defaultValue = "0" ,value = "page") Integer page) {
        return ResponseEntity.ok(service.getALlSPShop(page));
    }


    // TODO getALl sp lên trang chủ
    @GetMapping("/show")
    public ResponseEntity<?> getAllSP(@RequestParam(defaultValue = "0" ,value = "page") Integer page){
        return ResponseEntity.ok(service.getALlSPHome(page));
    }

    // TODO getALl sp Nam lên trang chủ
    @GetMapping("/show-nam")
    public ResponseEntity<?> getAllSPNam(@RequestParam(defaultValue = "0" ,value = "page") Integer page){
        return ResponseEntity.ok(service.getALlSPNamRepon(page));
    }

    // TODO getALl sp Nữ lên trang chủ
    @GetMapping("/show-nu")
    public ResponseEntity<?> getAllSPNu(@RequestParam(defaultValue = "0" ,value = "page") Integer page){
        return ResponseEntity.ok(service.getALlSPNuRepon(page));
    }

    // TODO getALl sp mới lên trang chủ
    @GetMapping("/show-new")
    public ResponseEntity<?> getAllSPNew(){
        return ResponseEntity.ok(service.getALlSPNewRepon());
    }

    // TODO getAll DanhMuc Theo Trang Thái 1
    @GetMapping("/hien-thi-danh-muc-shop")
    public ResponseEntity<?> getAllDMTheoTT(){
        return ResponseEntity.ok(service.getAllByDMTrangThai());
    }

    // TODO Tìm Kiếm Danh Mục Theo Tên Danh Mục
    @GetMapping("/loc-danh-muc")
    public ResponseEntity<?> findByNameDanhMuc(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
            @RequestParam("tendanhmuc") String tendanhmuc
    ){
        return ResponseEntity.ok(service.finByNameDanhMuc(pageNumber , pageSize , tendanhmuc));
    }

    // TODO getAll Size Theo Trang Thái 1
    @GetMapping("/hien-thi-size-shop")
    public ResponseEntity<?> getAllSizeTheoTT(){
        return ResponseEntity.ok(service.getAllBySizeTrangThai());
    }

    // TODO Lọc size sp
    @GetMapping("/loc-size")
    public ResponseEntity<?> findByNameSize(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
            @RequestParam("tensize") String tensize
    ){
        return ResponseEntity.ok(service.findByNameSize(pageNumber , pageSize , tensize));
    }

    // TODO Tìm kiếm theo tên sp
    @GetMapping("/loc-tensp")
    public ResponseEntity<?> findByNameSP(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
            @RequestParam("tensp") String tensp
    ){
        return ResponseEntity.ok(service.findByNameSP(pageNumber , pageSize , tensp));
    }

    // TODO getAll Size Theo Trang Thái 1
    @GetMapping("/hien-thi-mau-sac-shop")
    public ResponseEntity<?> getAllMSTheoTT(){
        return ResponseEntity.ok(service.getAllByMauSacTrangthai());
    }

    // TODO Tìm kiếm theo tên màu sắc
    @GetMapping("/loc-mau-sac")
    public ResponseEntity<?> findByNameMauSac(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
            @RequestParam("tenmausac") String tenmausac
    ){
        return ResponseEntity.ok(service.findByMauSac(pageNumber , pageSize , tenmausac));
    }

    // TODO Tìm kiếm theo tên màu sắc
    @GetMapping("/loc-gia-ban")
    public ResponseEntity<?> findBySPGiaBan(

            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
            @RequestParam("key1") Double key1,
            @RequestParam("key2") Double key2
    ){
        return ResponseEntity.ok(service.findBySPGiaBan(pageNumber , pageSize , key1, key2));
    }

}
