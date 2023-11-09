package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.dto.respon.ChiTietSPRepon;
import fpt.edu.duantn_th.dto.respon.SanPhamRepon;
import fpt.edu.duantn_th.entity.ChiTietSanPham;
import fpt.edu.duantn_th.entity.SanPham;
import fpt.edu.duantn_th.repository.SanPhamRepository;
import fpt.edu.duantn_th.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    SanPhamRepository sanPhamrepository;


    @Override
    public Page<SanPhamRepon> getALlPTSPRepon(Pageable pageable) {
        return sanPhamrepository.getAllPTSP(pageable);
    }

    @Override
    public List<SanPhamRepon> getALlSPRepon() {
        return sanPhamrepository.getAllSP();
    }

    @Override
    public List<SanPhamRepon> getALlSPNamRepon() {
        return sanPhamrepository.getAllSPNam();
    }

    @Override
    public List<SanPhamRepon> getALlSPNuRepon() {
        return sanPhamrepository.getAllSPNu();
    }

    @Override
    public List<SanPhamRepon> getALlSPNewRepon() {
        return sanPhamrepository.getAllSPNew();
    }

    @Override
    public List<SanPhamRepon> getByIdSP(UUID idsp) {
        return sanPhamrepository.getByIdSP(idsp);
    }

    @Override
    public List<SanPhamRepon> findByIdDM(UUID iddm) {
        return sanPhamrepository.findByIdDanhMuc(iddm);
    }

    @Override
    public List<SanPhamRepon> findByIdSize(UUID idsize) {
        return sanPhamrepository.findByIdSize(idsize);
    }

    @Override
    public List<SanPhamRepon> findByNameSP(String tensp) {
        return sanPhamrepository.findByNameSP(tensp);
    }
}
