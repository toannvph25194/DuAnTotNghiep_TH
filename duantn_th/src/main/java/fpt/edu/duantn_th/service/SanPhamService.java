package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.dto.respon.ChiTietSPRepon;
import fpt.edu.duantn_th.dto.respon.SanPhamRepon;
import fpt.edu.duantn_th.entity.ChiTietSanPham;
import fpt.edu.duantn_th.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    // Load ctsp respon
    List<SanPhamRepon> getALlSPRepon();

    // Load ctsp respon
    List<SanPhamRepon> getALlSPNamRepon();

    // Load ctsp respon
    List<SanPhamRepon> getALlSPNuRepon();

    // Detail ctsp respon

    List<SanPhamRepon> getByIdSP(UUID idsp);

    // FindById Danh Mục
    List<SanPhamRepon> findByIdDM(UUID iddm);

    // FindById Size
    List<SanPhamRepon> findByIdSize(UUID idsize);

    // FindByName Sản Phẩm
    List<SanPhamRepon> findByNameSP(String tensp);

}
