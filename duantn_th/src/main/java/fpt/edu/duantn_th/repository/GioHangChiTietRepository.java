package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.dto.respon.GioHangCTRepon;
import fpt.edu.duantn_th.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {

    // Load giỏ hàng
    @Query(value = "select  ctsp.GiaBan , img.TenImage,  sp.TenSP , ms.TenMauSac , s.tensize, ghct.SoLuong , cl.TenChatLieu from ChiTietSP ctsp\n" +
            "            \n" +
            "                                       join SanPham sp on ctsp.IdSP = sp.Id\n" +
            "                                       join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                                       join ChatLieu cl on ctsp.IdChatLieu = cl.Id\n" +
            "                                       join Size s on ctsp.IdSize = s.Id\n" +
            "\t\t\t\t\t\t\t\t\t   join GioHangChiTiet ghct on ghct.IdCTSP = ctsp.id\n" +
            "\t\t\t\t\t\t\t\t\t   join GioHang gh on gh.Id = ghct.IdGioHang\n" +
            "                                       Join Image img on ctsp.Id = img.IdCTSP \n" +
            "                                       where img.isdefault = 'True'  AND ghct.SoLuong > 0  AND gh.Id = ?", nativeQuery = true)
    List<GioHangCTRepon> getAllGhCT(UUID idgh);

    // Tìm kiếm idspct and idgh trong ghct
    GioHangChiTiet findByGiohang_IdgiohangAndCtsp_Idctsp(UUID idgiohang, UUID idctsp);

}
