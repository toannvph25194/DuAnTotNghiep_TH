package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.dto.respon.SanPhamRepon;
import fpt.edu.duantn_th.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham , UUID> {

    // getALl PT sản phẩm 1 ảnh
    @Query(value ="select sp.Id,MaSP,TenSP,TheLoai ,ctsp.GiaBan,SoLuongTon , img.TenImage from SanPham sp\n" +
            "     \n" +
            "                        join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                        join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                        join Size s on ctsp.IdSize = s.Id\n" +
            "                        join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                        join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "                        join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "                        Join Image img on ctsp.Id = img.IdCTSP where img.isdefault = 'true'" ,nativeQuery = true)
    Page<SanPhamRepon> getAllPTSP(Pageable pageable);

    // getALl sản phẩm 1 ảnh
    @Query(value ="select DISTINCT sp.Id,MaSP,TenSP,TheLoai ,ctsp.GiaBan,SoLuongTon , img.TenImage from SanPham sp\n" +
            "     \n" +
            "                        join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                        join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                        join Size s on ctsp.IdSize = s.Id\n" +
            "                        join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                        join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "                        join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "                        Join Image img on ctsp.Id = img.IdCTSP where img.isdefault = 'true'" ,nativeQuery = true)
    List<SanPhamRepon> getAllSP();

    // getALl sản phẩm của nam và 1 ảnh
    @Query(value ="select DISTINCT sp.Id,MaSP,TenSP,TheLoai , ctsp.GiaBan,SoLuongTon , img.TenImage from SanPham sp\n" +
            "           \n" +
            "                                    join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                                    join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                                    join Size s on ctsp.IdSize = s.Id\n" +
            "                                    join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                                    join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "                                    join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "                                    Join Image img on ctsp.Id = img.IdCTSP \n" +
            "            where img.isdefault = 'True' AND sp.TheLoai = 'True'" ,nativeQuery = true)
    List<SanPhamRepon> getAllSPNam();

    // getALl sản phẩm của nữ và 1 ảnh
    @Query(value ="select DISTINCT  sp.Id,MaSP,TenSP,TheLoai , ctsp.GiaBan,SoLuongTon , img.TenImage from SanPham sp\n" +
            "           \n" +
            "                                    join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                                    join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                                    join Size s on ctsp.IdSize = s.Id\n" +
            "                                    join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                                    join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "                                    join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "                                    Join Image img on ctsp.Id = img.IdCTSP \n" +
            "            where img.isdefault = 'True' AND sp.TheLoai = 'False'" ,nativeQuery = true)
    List<SanPhamRepon> getAllSPNu();

    // getALl sản phẩm mới nhất và 1 ảnh
    @Query(value ="select top 6 sp.Id,MaSP,TenSP,TheLoai,NgayThemSP ,ctsp.GiaBan,SoLuongTon , img.TenImage,  ms.TenMauSac , dm.tendanhmuc , s.tensize  from SanPham sp\n" +
            "            \n" +
            "                                    join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                                    join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                                    join Size s on ctsp.IdSize = s.Id\n" +
            "                                    join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                                    join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "                                    join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "                                    Join Image img on ctsp.Id = img.IdCTSP where img.isdefault = 'true'\n" +
            "\t\t\t\t\t\t\t\t\tORDER BY sp.NgayThemSP DESC; " ,nativeQuery = true)
    List<SanPhamRepon> getAllSPNew();

    // findById Tên SP
    @Query(value = "select sp.Id,TenSP,TheLoai , ctsp.GiaBan,SoLuongTon , img.TenImage , ms.TenMauSac , s.tensize  from SanPham sp\n" +
            "            \n" +
            "                                   join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                                   join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                                   join Size s on ctsp.IdSize = s.Id\n" +
            "                                   join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                                   join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "                                   join XuatXu xx on xx.Id = sp.IdXuatXu \n" +
            "                                   Join Image img on ctsp.Id = img.IdCTSP \n" +
            "                                   where img.isdefault = 'true'  AND sp.TenSP Like %:tensp%", nativeQuery = true)
    List<SanPhamRepon> findByNameSP(@Param("tensp") String tensp);

    // findById Danh Mục
    @Query(value = "select sp.Id,TenSP,TheLoai , ctsp.GiaBan,SoLuongTon , img.TenImage , ms.TenMauSac , s.tensize  from SanPham sp\n" +
            "                                       \n" +
            "                           join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                           join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                           join Size s on ctsp.IdSize = s.Id\n" +
            "                           join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                           join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "                           join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "                           Join Image img on ctsp.Id = img.IdCTSP \n" +
            "              where img.isdefault = 'true' AND dm.Id = ?", nativeQuery = true)

    List<SanPhamRepon> findByIdDanhMuc(UUID iddm);


    // findById Size
    @Query(value = "select sp.Id,TenSP,TheLoai , ctsp.GiaBan,SoLuongTon , img.TenImage , ms.TenMauSac , s.tensize  from SanPham sp\n" +
            "                                       \n" +
            "                           join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                           join  MauSac ms on ctsp.IdMauSac = ms.Id\n" +
            "                           join Size s on ctsp.IdSize = s.Id\n" +
            "                           join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                           join ThuongHieu th on th.Id = sp.IdThuongHieu\n" +
            "                           join XuatXu xx on xx.Id = sp.IdXuatXu\n" +
            "                           Join Image img on ctsp.Id = img.IdCTSP \n" +
            "              where img.isdefault = 'true' AND s.Id = ?", nativeQuery = true)
    List<SanPhamRepon> findByIdSize(UUID idsize);


}
