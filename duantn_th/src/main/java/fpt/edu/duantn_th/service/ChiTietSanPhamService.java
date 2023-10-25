package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.dto.respon.ChiTietSPRepon;
import fpt.edu.duantn_th.entity.ChiTietSanPham;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {

    // Load ctsp respon
    List<ChiTietSPRepon> getALlCTSPRepon();

    // Load ctsp bình thường
    List<ChiTietSanPham> getALlCTSP();

    // Detail ctsp respon

    List<ChiTietSPRepon> getByIdCTSP(UUID idctsp);

    // FindById Danh Mục
    List<ChiTietSPRepon> findByIdDM(UUID iddm);

    // FindById Size
    List<ChiTietSPRepon> findByIdSize(UUID idsize);

    // FindByName Sản Phẩm
    List<ChiTietSPRepon> findByNameSP(String tensp);
}
