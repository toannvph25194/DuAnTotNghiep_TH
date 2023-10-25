package fpt.edu.duantn_th.service.Impl;


import fpt.edu.duantn_th.entity.GioHang;
import fpt.edu.duantn_th.entity.User;
import fpt.edu.duantn_th.repository.GioHangRepository;
import fpt.edu.duantn_th.repository.UserRepository;
import fpt.edu.duantn_th.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

@Service

public class GioHangServiceImpl implements GioHangService {

    @Autowired
    GioHangRepository repository;

    @Autowired
    UserRepository userRepository;


    @Override
    public GioHang createGioHang(GioHang gh, UUID id) {

        User us = userRepository.findById(id).orElse(null);

        GioHang giohang = new GioHang();

        giohang.setIdgiohang(UUID.randomUUID());
        giohang.setUsers(us);
        giohang.setNgaytao(gh.getNgaytao());
        giohang.setNgaycapnhat(gh.getNgaycapnhat());
        giohang.setGhichu(gh.getGhichu());
        giohang.setTrangthai(1L);

        repository.save(giohang);
        return gh;
    }
}
