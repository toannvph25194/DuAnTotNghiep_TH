package fpt.edu.duantn_th.service.mua_hang_online_service_Impl;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.DanhMucShopRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.MauSacShopRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.SanPhamRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.SizeShopRepon;
import fpt.edu.duantn_th.entity.DanhMuc;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.SanPhamRepository;
import fpt.edu.duantn_th.service.mua_hang_online_service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    SanPhamRepository sanPhamrepository;


    @Override
    public Page<SanPhamRepon> getALlSPShop(Integer page) {
        Pageable pageable = PageRequest.of(page, 9);
        return sanPhamrepository.getAllSPShop(pageable);
    }

    @Override
    public Page<SanPhamRepon> getALlSPHome(Integer page) {
        Pageable pageable = PageRequest.of(page, 12);
        return sanPhamrepository.getAllSPHome(pageable);
    }

    @Override
    public Page<SanPhamRepon> getALlSPNamRepon(Integer page) {
        Pageable pageable = PageRequest.of(page, 12);
        return sanPhamrepository.getAllSPNam(pageable);
    }

    @Override
    public Page<SanPhamRepon> getALlSPNuRepon(Integer page) {
        Pageable pageable = PageRequest.of(page, 12);
        return sanPhamrepository.getAllSPNu(pageable);
    }

    @Override
    public List<SanPhamRepon> getALlSPNewRepon() {
        return sanPhamrepository.getAllSPNew();
    }

    @Override
    public List<DanhMucShopRepon> getAllByDMTrangThai() {
        return sanPhamrepository.getAllByDMTrangthai();
    }

    @Override
    public Page<SanPhamRepon> finByNameDanhMuc(Integer pageNumber, Integer pageSize, String tendanhmuc) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sanPhamrepository.finByNameDanhMuc(pageable, tendanhmuc);
    }

    @Override
    public List<SizeShopRepon> getAllBySizeTrangThai() {
        return sanPhamrepository.getAllBySizeTrangthai();
    }

    @Override
    public Page<SanPhamRepon> findByNameSize(Integer pageNumber, Integer pageSize, String tensize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sanPhamrepository.findByNameSize(pageable , tensize);
    }

    @Override
    public List<SanPhamRepon> findByNameSP(Integer pageNumber, Integer pageSize, String tensp) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sanPhamrepository.findByNameSP(pageable,tensp);
    }

    @Override
    public List<MauSacShopRepon> getAllByMauSacTrangthai() {
        return sanPhamrepository.getAllByMauSacTrangthai();
    }

    @Override
    public Page<SanPhamRepon> findByMauSac(Integer pageNumber, Integer pageSize, String tenmausac) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sanPhamrepository.findByMauSac(pageable , tenmausac);
    }

    @Override
    public Page<SanPhamRepon> findBySPGiaBan(Integer pageNumber, Integer pageSize, Double key1, Double key2) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sanPhamrepository.findByGiaSP(pageable,key1,key2);
    }
}
