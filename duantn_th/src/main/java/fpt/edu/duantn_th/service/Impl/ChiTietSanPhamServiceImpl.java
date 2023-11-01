package fpt.edu.duantn_th.service.Impl;


import fpt.edu.duantn_th.dto.respon.ChiTietSPRepon;
import fpt.edu.duantn_th.entity.ChiTietSanPham;
import fpt.edu.duantn_th.repository.ChiTietSanPhamRepository;
import fpt.edu.duantn_th.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    ChiTietSanPhamRepository repository;
}
