package fpt.edu.duantn_th.repository.mua_hang_online_repository;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.*;
import fpt.edu.duantn_th.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham , UUID> {

    // Detail SP
    @Query(value = "SELECT DISTINCT sp.id , sp.GiaBan , sp.TenSP , img.TenImage , xx.TenXuatXu , th.TenThuongHieu FROM ChiTietSP ctsp\n" +
            "INNER JOIN SanPham sp ON sp.Id = ctsp.IdSP\n" +
            "INNER JOIN XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "INNER JOIN ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "INNER JOIN ChatLieu cl on cl.Id = sp.IdChatLieu\n" +
            "INNER JOIN Image img on img.IdSP = sp.id\n" +
            "where img.isdefault = 'True' AND sp.Id = ?", nativeQuery = true)

    ChiTietSPRepon detailSP(UUID idsp);

    // getALl sản phẩm mới nhất và 1 ảnh tại trang ctsp
    @Query(value ="SELECT DISTINCT TOP 4 sp.Id,MaSP,TenSP,TheLoai,NgayThemSP ,sp.GiaBan , img.TenImage  from SanPham sp\n" +
            "            \n" +
            "                        join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                        Join Image img on sp.Id = img.IdSP where img.isdefault = 'True'\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\tORDER BY sp.NgayThemSP DESC; \n" ,nativeQuery = true)
    List<SanPhamRepon> getAllSPNewTaiCTSP();

    // Load Tổng Số Lượng SP detail
    @Query(value = "SELECT SUM(ctsp.SoLuongTon) AS TongSoLuongSP FROM ChiTietSP ctsp\n" +
            "INNER JOIN SanPham sp on sp.Id = ctsp.IdSP\n" +
            "where sp.Id = ?", nativeQuery = true)
    TongSoLuongSPRepon loadTongSoLuongSP(UUID idsp);

    // Detail mausac
    @Query(value = "SELECT DISTINCT  ms.Id,TenMauSac \n" +
            "From MauSac ms\n" +
            "INNER JOIN ChiTietSP ctsp on ms.Id = ctsp.IdMauSac\n" +
            "INNER JOIN SanPham sp on sp.Id = ctsp.IdSP\n" +
            "Where sp.Id = ?", nativeQuery = true)
    List<DetailMauSacRepon> detailMauSac(UUID idsp);

    // Detail size
    @Query(value = "SELECT DISTINCT  s.Id,TenSize \n" +
            "From Size s\n" +
            "INNER JOIN ChiTietSP ctsp on s.Id = ctsp.IdSize\n" +
            "INNER JOIN SanPham sp on sp.Id = ctsp.IdSP\n" +
            "Where sp.Id = ?" ,nativeQuery = true)
    List<DetailSizeRepon> detailSize(UUID idsp);


    // Tìm Kiếm size theo idsp và idmausac
    @Query(value = "select s.TenSize , ctsp.SoLuongTon from ChiTietSP ctsp \n" +
            "INNER JOIN MauSac ms on ms.Id = ctsp.IdMauSac\n" +
            "INNER JOIN SanPham sp on sp.Id = ctsp.IdSP\n" +
            "INNER JOIN Size s on s.Id = ctsp.IdSize\n" +
            "where sp.Id = ? AND ms.Id = ?\n", nativeQuery = true)
    List<TimKiemSizeRepon> timKiemSize(UUID idsp, UUID idmausac);

    // Tìm Kiếm màu sắc theo idsp và idsize
    @Query(value = "select ms.TenMauSac , ctsp.SoLuongTon from ChiTietSP ctsp \n" +
            "INNER JOIN SanPham sp on sp.Id = ctsp.IdSP\n" +
            "INNER JOIN MauSac ms on ms.Id = ctsp.IdMauSac\n" +
            "INNER JOIN Size s on s.Id = ctsp.IdSize\n" +
            "where sp.Id = ? AND s.Id = ?", nativeQuery = true)
    List<TimKiemMauSacRepon> timKiemMauSac(UUID idsp, UUID idsize);

    // Tìm kiếm idCTSP theo idsp , idmausac , idsize
    @Query( value = "select ctsp.Id,SoLuongTon from ChiTietSP ctsp\n" +
            "INNER JOIN SanPham sp on sp.id = ctsp.IdSP\n" +
            "INNER JOIN MauSac ms on ms.Id = ctsp.IdMauSac\n" +
            "INNER JOIN Size s on s.Id = ctsp.IdSize\n" +
            "where sp.Id = ? AND ms.Id = ? AND s.Id = ?\n", nativeQuery = true)
    TimKiemIDCTSPRepon timkiemIdCTSP(UUID idsp, UUID idmausac , UUID idsize);


}
