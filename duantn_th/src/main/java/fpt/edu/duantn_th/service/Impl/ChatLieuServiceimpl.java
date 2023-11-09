package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.entity.ChatLieu;
import fpt.edu.duantn_th.entity.MauSac;
import fpt.edu.duantn_th.repository.ChatLieuRepository;
import fpt.edu.duantn_th.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ChatLieuServiceimpl implements ChatLieuService {
    @Autowired
    ChatLieuRepository chatLieuRepository;
    @Override
    public List<ChatLieu> getAllchatlieu() {
        return chatLieuRepository.findAll();
    }

    @Override
    public ChatLieu deletechatlieu(UUID idcl) {
        ChatLieu chatLieu = chatLieuRepository.findById(idcl).orElse(null);
        chatLieuRepository.delete(chatLieu);
        return chatLieu;
    }

    @Override
    public ChatLieu addchatlieu(ChatLieu chatLieu) {
        return  chatLieuRepository.save(chatLieu);
    }

    @Override
    public ChatLieu updatechatlieu(ChatLieu chatLieu, UUID idcl) {
        Optional<ChatLieu> chatLieu1 = chatLieuRepository.findById(idcl);

        return chatLieu1.map(o -> {

            o.setTenchatlieu(chatLieu.getTenchatlieu());
            o.setTrangthai(chatLieu.getTrangthai());

            return chatLieuRepository.save(o);
        }).orElse(null);    }
}
