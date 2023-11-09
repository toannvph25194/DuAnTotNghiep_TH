package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.entity.ChatLieu;
import fpt.edu.duantn_th.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface ChatLieuService {
    // show
    public List<ChatLieu> getAllchatlieu();

    // delete
    ChatLieu deletechatlieu(UUID idcl);

    //add
    ChatLieu addchatlieu(ChatLieu chatLieu);

    //update
    ChatLieu updatechatlieu(ChatLieu chatLieu , UUID idcl);
}
