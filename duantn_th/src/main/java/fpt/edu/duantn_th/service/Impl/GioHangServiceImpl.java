package fpt.edu.duantn_th.service.Impl;


import fpt.edu.duantn_th.dto.respon.TimKiemIdGH;
import fpt.edu.duantn_th.entity.GioHang;
import fpt.edu.duantn_th.entity.User;
import fpt.edu.duantn_th.repository.GioHangRepository;
import fpt.edu.duantn_th.repository.UserRepository;
import fpt.edu.duantn_th.service.GioHangService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class GioHangServiceImpl implements GioHangService {

    @Autowired
    GioHangRepository repository;

    @Autowired
    UserRepository userRepository;


    @Override
    public GioHang createGioHang(GioHang gh, UUID idtk) {

            List<GioHang> giohangcheck = repository.findByUsers_IdtkAndTrangthai(idtk, 1);
                if (giohangcheck.isEmpty()) {

                    User us = userRepository.findById(idtk).orElse(null);
                    GioHang giohang = new GioHang();
                    giohang.setIdgiohang(UUID.randomUUID());
                    giohang.setUsers(us);
                    giohang.setNgaytao(gh.getNgaytao());
                    giohang.setNgaycapnhat(gh.getNgaycapnhat());
                    giohang.setGhichu(gh.getGhichu());
                    giohang.setTrangthai(1);

                    return repository.save(giohang);
                } else {

                    throw new EntityNotFoundException();
                }


    }

    @Override
    public TimKiemIdGH findByIdgiohang(UUID idtk) {
        return repository.findByIdgiohang(idtk);
    }
}
