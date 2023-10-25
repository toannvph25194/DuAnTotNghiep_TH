package fpt.edu.duantn_th.controller;


import fpt.edu.duantn_th.entity.ChucVu;
import fpt.edu.duantn_th.service.Impl.ChucVuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chuc-vu")
public class ChucVuController {

    @Autowired
    ChucVuServiceImpl chucVuServiceimpl;

    // TODO getALl địa chỉ
    @GetMapping("/show")
    public ResponseEntity<?> getAllChucvu(){
        return ResponseEntity.ok(chucVuServiceimpl.getAllchucvu());
    }

    // TODO delete địa chỉ
    @DeleteMapping("/delete/{idchucvu}")
    public ResponseEntity<?> deletechucvu(@PathVariable("idchucvu") Long idcv){
        return ResponseEntity.ok(chucVuServiceimpl.deletechucvu(idcv));
    }

    // TODO update địa chỉ
    @PutMapping("/update/{idchucvu}")
    public ResponseEntity<?> updatechucvu( @RequestBody ChucVu cv ,@PathVariable("idchucvu") Long idcv){
        return ResponseEntity.ok(chucVuServiceimpl.updatechucvu(cv,idcv));
    }

    // TODO add địa chỉ
    @PostMapping("/add")
    public ResponseEntity<?> addchucvu(@RequestBody ChucVu cv){
        return ResponseEntity.ok(chucVuServiceimpl.addchucvu(cv));
    }
}
