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

    @Override
    public List<ChiTietSPRepon> getALlCTSPRepon() {
        return repository.getAllCTSP();
    }

    @Override
    public List<ChiTietSanPham> getALlCTSP() {
        return repository.findAll();
    }

    @Override
    public  List<ChiTietSPRepon> getByIdCTSP(UUID idctsp) {
        return repository.getByIdCTSP(idctsp);
    }

    @Override
    public List<ChiTietSPRepon> findByIdDM(UUID iddm) {
        return repository.findByIdDanhMuc(iddm);
    }

    @Override
    public List<ChiTietSPRepon> findByIdSize(UUID idsize) {
        return repository.findByIdSize(idsize);
    }

    @Override
    public List<ChiTietSPRepon> findByNameSP(String tensp) {
        return repository.findByNameSP(tensp);
    }

}
