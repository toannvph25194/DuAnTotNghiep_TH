package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.dto.respon.ChiTietSPRepon;
import fpt.edu.duantn_th.dto.respon.SanPhamRepon;
import fpt.edu.duantn_th.entity.ChiTietSanPham;
import fpt.edu.duantn_th.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    // Load PT sp respon
    Page<SanPhamRepon> getALlPTSPRepon(Pageable pageable);

    // Load sp respon
    List<SanPhamRepon> getALlSPRepon();

    // Load sp respon
    List<SanPhamRepon> getALlSPNamRepon();

    // Load sp respon
    List<SanPhamRepon> getALlSPNuRepon();

    // Load sp mới respon
    List<SanPhamRepon> getALlSPNewRepon();

    // Detail sp respon

    List<SanPhamRepon> getByIdSP(UUID idsp);

    // FindById Danh Mục
    List<SanPhamRepon> findByIdDM(UUID iddm);

    // FindById Size
    List<SanPhamRepon> findByIdSize(UUID idsize);

    // FindByName Sản Phẩm
    List<SanPhamRepon> findByNameSP(String tensp);

}
