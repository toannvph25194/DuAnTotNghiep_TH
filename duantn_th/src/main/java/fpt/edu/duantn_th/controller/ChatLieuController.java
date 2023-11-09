package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.entity.ChatLieu;
import fpt.edu.duantn_th.entity.MauSac;
import fpt.edu.duantn_th.service.Impl.ChatLieuServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/chat-lieu")
public class ChatLieuController {
    @Autowired
    ChatLieuServiceimpl chatLieuServiceimpl;
    @GetMapping("/show")
    public ResponseEntity<?> getAllChatLieu(){
        return ResponseEntity.ok(chatLieuServiceimpl.getAllchatlieu());
    }

    @DeleteMapping("/delete/chat-lieu/{idchatlieu}")
    public ResponseEntity<?> deletechatlieu(@PathVariable("idchatlieu") UUID idcl){
        return ResponseEntity.ok(chatLieuServiceimpl.deletechatlieu( idcl));
    }

    @PutMapping("/update/chat-lieu/{idchatlieu}")
    public ResponseEntity<?> updatechatlieu(@RequestBody ChatLieu chatLieu , @PathVariable("idchatlieu") UUID idcl){
        return ResponseEntity.ok(chatLieuServiceimpl.updatechatlieu(chatLieu,idcl));
    }

    @PostMapping("/add/chat-lieu")
    public ResponseEntity<?> addchatlieu(@RequestBody ChatLieu chatLieu){
        return ResponseEntity.ok(chatLieuServiceimpl.addchatlieu(chatLieu));
    }
}
