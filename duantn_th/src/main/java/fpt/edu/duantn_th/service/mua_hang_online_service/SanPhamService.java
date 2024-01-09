package fpt.edu.duantn_th.service.mua_hang_online_service;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.DanhMucShopRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.MauSacShopRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.SanPhamRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.SizeShopRepon;
import fpt.edu.duantn_th.entity.DanhMuc;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    // Load PT sp respon
    Page<SanPhamRepon> getALlSPShop(Integer page);

    // Load sp respon
    Page<SanPhamRepon> getALlSPHome(Integer page);

    // Load sp Nam respon
    Page<SanPhamRepon> getALlSPNamRepon(Integer page);

    // Load sp Nu respon
    Page<SanPhamRepon> getALlSPNuRepon(Integer page);

    // Load sp mới respon
    List<SanPhamRepon> getALlSPNewRepon();

    // getAll Danh Mục Theo Trạng Thái
    List<DanhMucShopRepon> getAllByDMTrangThai();

    // Tìm Kiếm Danh Mục Theo Tên
    Page<SanPhamRepon> finByNameDanhMuc(Integer pageNumber, Integer pageSize, String tendanhmuc);

    // getAll Size Theo Trạng Thái
    List<SizeShopRepon> getAllBySizeTrangThai();

    // FindById Size
    Page<SanPhamRepon> findByNameSize(Integer pageNumber, Integer pageSize, String tensize);

    // FindByName Sản Phẩm
    List<SanPhamRepon> findByNameSP(Integer pageNumber, Integer pageSize, String tensp);

    // getAll Màu Sắc Theo Trạng Thái
    List<MauSacShopRepon> getAllByMauSacTrangthai();

    // FindByName Màu Sắc
    Page<SanPhamRepon> findByMauSac(Integer pageNumber, Integer pageSize, String tenmausac);

    // FindByName Sản Phẩm Theo Giá Bán
    Page<SanPhamRepon> findBySPGiaBan(Integer pageNumber, Integer pageSize, Double key1, Double key2);
}
