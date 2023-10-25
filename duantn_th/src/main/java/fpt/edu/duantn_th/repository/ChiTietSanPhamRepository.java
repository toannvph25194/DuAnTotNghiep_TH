package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.dto.respon.ChiTietSPRepon;
import fpt.edu.duantn_th.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham , UUID> {

    // getALl sản phẩm 1 ảnh
    @Query(value ="select   ctsp.Id,GiaBan,SoLuongTon , img.TenImage,  sp.MaSP,TenSP,TheLoai , ms.TenMauSac , s.tensize , cl.TenChatLieu from ChiTietSP ctsp\n" +
            "         \n" +
            "            join SanPham sp on ctsp.IdSP = sp.Id\n" +
            "            join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "            join ChatLieu cl on ctsp.IdChatLieu = cl.Id\n" +
            "            join Size s on ctsp.IdSize = s.Id\n" +
            "            join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "            join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "            join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "            Join Image img on ctsp.Id = img.IdCTSP where img.isdefault = 'true'" ,nativeQuery = true)
    List<ChiTietSPRepon> getAllCTSP();

    // Detail sản phẩm chi tiết
    @Query(value = "select  ctsp.id,GiaBan,SoLuongTon , img.TenImage,  sp.MaSP,TenSP,TheLoai , ms.TenMauSac , s.tensize , cl.TenChatLieu from ChiTietSP ctsp\n" +
            "                         \n" +
            "              join SanPham sp on ctsp.IdSP = sp.Id\n" +
            "              join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "              join ChatLieu cl on ctsp.IdChatLieu = cl.Id\n" +
            "              join Size s on ctsp.IdSize = s.Id\n" +
            "              join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "              join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "              join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "              Join Image img on ctsp.Id = img.IdCTSP \n" +
            "\t\t\t  where img.isdefault = 'false'  AND ctsp.Id = ?", nativeQuery = true)
    List<ChiTietSPRepon> getByIdCTSP(UUID idsp);


    // findById Tên SP
    @Query(value = "select  ctsp.id,GiaBan,SoLuongTon , img.TenImage,  sp.MaSP,TenSP,TheLoai , ms.TenMauSac , s.tensize , cl.TenChatLieu from ChiTietSP ctsp\n" +
            "           \n" +
            "                       join SanPham sp on ctsp.IdSP = sp.Id\n" +
            "                       join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                       join ChatLieu cl on ctsp.IdChatLieu = cl.Id\n" +
            "                       join Size s on ctsp.IdSize = s.Id\n" +
            "                       join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                       join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "                       join XuatXu xx on xx.Id = sp.IdXuatXu \n" +
            "                       Join Image img on ctsp.Id = img.IdCTSP \n" +
            "                       where img.isdefault = 'true'  AND sp.TenSP Like %:tensp%", nativeQuery = true)
    List<ChiTietSPRepon> findByNameSP(@Param("tensp") String tensp);

    // findById Danh Mục
    @Query(value = "select  ctsp.id,GiaBan,SoLuongTon , img.TenImage,  sp.MaSP,TenSP,TheLoai , ms.TenMauSac , s.tensize , cl.TenChatLieu from ChiTietSP ctsp\n" +
            "                           \n" +
            "               join SanPham sp on ctsp.IdSP = sp.Id\n" +
            "               join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "               join ChatLieu cl on ctsp.IdChatLieu = cl.Id\n" +
            "               join Size s on ctsp.IdSize = s.Id\n" +
            "               join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "               join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "               join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "               Join Image img on ctsp.Id = img.IdCTSP \n" +
            "\t\t\t   where img.isdefault = 'true' AND dm.Id = ?", nativeQuery = true)

    List<ChiTietSPRepon> findByIdDanhMuc(UUID iddm);


    // findById Size
    @Query(value = "select  ctsp.id,GiaBan,SoLuongTon , img.TenImage,  sp.MaSP,TenSP,TheLoai , ms.TenMauSac , s.tensize , cl.TenChatLieu from ChiTietSP ctsp\n" +
            "          \n" +
            "            join SanPham sp on ctsp.IdSP = sp.Id\n" +
            "            join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "            join ChatLieu cl on ctsp.IdChatLieu = cl.Id\n" +
            "            join Size s on ctsp.IdSize = s.Id\n" +
            "            join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "            join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "            join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "            Join Image img on ctsp.Id = img.IdCTSP \n" +
            "            where img.isdefault = 'true' AND s.Id = ?", nativeQuery = true)
    List<ChiTietSPRepon> findByIdSize(UUID idsize);


}
