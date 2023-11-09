package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.entity.Image;
import fpt.edu.duantn_th.service.Impl.ImageServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    ImageServiceimpl imageServiceimpl;

    @GetMapping("/show")
    public ResponseEntity<?> getAllImage(){
        return ResponseEntity.ok(imageServiceimpl.getAllimg());
    }

    @DeleteMapping("/delete/image/{idimg}")
    public ResponseEntity<?> deleteimage(@PathVariable("idimg") UUID idimg){
        return ResponseEntity.ok(imageServiceimpl.deleteimage(idimg));
    }

    @PutMapping("/update/image/{idimg}")
    public ResponseEntity<?> updateimage(@RequestBody Image image , @PathVariable("idimg") UUID idmg){
        return ResponseEntity.ok(imageServiceimpl.updateimage(image,idmg));
    }

    @PostMapping("/add/image")
    public ResponseEntity<?> addimage(@RequestBody Image image){
        return ResponseEntity.ok(imageServiceimpl.addimage(image));
    }
}
