package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.dto.respon.CheckoutRepon;
import fpt.edu.duantn_th.dto.respon.GioHangCTRepon;
import fpt.edu.duantn_th.dto.respon.TongSoTienRepon;
import fpt.edu.duantn_th.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {

    // Load giỏ hàng
    @Query(value = "select ghct.Id , ctsp.GiaBan , img.TenImage,  sp.TenSP , ms.TenMauSac , s.tensize, ghct.SoLuong  from ChiTietSP ctsp\n" +
            "            \n" +
            "                                       join SanPham sp on ctsp.IdSP = sp.Id\n" +
            "                                       join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                                       join Size s on ctsp.IdSize = s.Id\n" +
            "\t\t\t\t\t\t\t\t\t   join GioHangChiTiet ghct on ghct.IdCTSP = ctsp.id\n" +
            "\t\t\t\t\t\t\t\t\t   join GioHang gh on gh.Id = ghct.IdGioHang\n" +
            "                                       Join Image img on sp.Id = img.IdSP \n" +
            "                                       where img.isdefault = 'True'  AND ghct.SoLuong > 0  AND gh.Id = ?", nativeQuery = true)
    List<GioHangCTRepon> getAllGhCT(UUID idgiohang);

    // Tìm kiếm idspct and idgh trong ghct
    GioHangChiTiet findByGiohang_IdgiohangAndCtsp_Idctsp(UUID idgiohang, UUID idctsp);

    // Load all checkout tổng tiền
    @Query( value = "SELECT ghct.id , sp.TenSP , img.TenImage , ghct.SoLuong ,(ctsp.GiaBan * ghct.soluong) AS tongtien\n" +
            "                        FROM giohang gh\n" +
            "                        JOIN giohangchitiet ghct ON gh.id = ghct.IdGioHang\n" +
            "                        JOIN ChiTietSP ctsp ON ghct.IdCTSP = ctsp.id\n" +
            "\t\t\t\t\t\tJOIN sanpham sp ON ctsp.IdSP = sp.id\n" +
            "\t\t\t\t\t\tJoin Image img on img.IdSP = sp.Id\n" +
            "                        WHERE gh.id = :idgh and img.isdefault = 'true' and gh.trangthai = 1 AND ghct.SoLuong > 0", nativeQuery = true)

    List<CheckoutRepon> getAllTongTien(@Param("idgh") UUID idgiohang);

    // Tính tổng tiền

    @Query( value = "SELECT  SUM(ctsp.GiaBan * ghct.soluong) AS TongSoTien\n" +
            "                        FROM ChiTietSP ctsp\n" +
            "                        JOIN sanpham sp ON ctsp.IdSP = sp.id\n" +
            "                        join image img on sp.Id = img.IdSP\n" +
            "                        JOIN giohangchitiet ghct ON ghct.IdCTSP = ctsp.id\n" +
            "                        JOIN giohang gh ON gh.id = ghct.IdGioHang\n" +
            "                        WHERE img.isdefault = 'true' AND gh.id = :idgh AND ghct.SoLuong > 0" , nativeQuery = true)
    List<TongSoTienRepon> getTongSoTien(@Param("idgh") UUID idgiohang);
}
