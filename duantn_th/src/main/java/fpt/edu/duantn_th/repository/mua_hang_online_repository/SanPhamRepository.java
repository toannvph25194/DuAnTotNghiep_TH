package fpt.edu.duantn_th.repository.mua_hang_online_repository;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.SanPhamRepon;
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
    @Query(value = "SELECT COUNT(DISTINCT sp.Id) , sp.Id,MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage \n" +
            "FROM SanPham sp\n" +
            "JOIN Image img ON sp.Id = img.IdSP \n" +
            "JOIN ChiTietSP ctsp ON ctsp.IdSP = sp.Id\n" +
            "WHERE img.isdefault = 'TRUE'\n" +
            "GROUP BY sp.Id, sp.MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage", nativeQuery = true)
    Page<SanPhamRepon> getAllPTSP(Pageable pageable);


    // getALl sản phẩm 1 ảnh
    @Query(value ="select DISTINCT sp.Id,MaSP,TenSP,TheLoai , sp.GiaBan , img.TenImage from SanPham sp\n" +
            "INNER JOIN ChiTietSP ctsp on sp.Id = ctsp.IdSP\n" +
            "INNER JOIN Image img on sp.Id = img.IdSP\n" +
            "where img.isdefault = 'TRUE'" ,nativeQuery = true)
    List<SanPhamRepon> getAllSP();

    // getALl sản phẩm của nam và 1 ảnh
    @Query(value ="select DISTINCT sp.Id,MaSP,TenSP,TheLoai , sp.GiaBan , img.TenImage from SanPham sp\n" +
            "           \n" +
            "                                    join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                                    Join Image img on sp.Id = img.IdSP \n" +
            "            where img.isdefault = 'True' AND sp.TheLoai = 'TRUE'" ,nativeQuery = true)
    List<SanPhamRepon> getAllSPNam();

    // getALl sản phẩm của nữ và 1 ảnh
    @Query(value ="select DISTINCT  sp.Id,MaSP,TenSP,TheLoai , sp.GiaBan , img.TenImage from SanPham sp\n" +
            "           \n" +
            "                                    join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                                    Join Image img on sp.Id = img.IdSP \n" +
            "            where img.isdefault = 'TRUE' AND sp.TheLoai = 'False'" ,nativeQuery = true)
    List<SanPhamRepon> getAllSPNu();

    // getALl sản phẩm mới nhất và 1 ảnh
    @Query(value ="SELECT DISTINCT TOP 10 sp.Id,MaSP,TenSP,TheLoai,NgayThemSP ,sp.GiaBan , img.TenImage  from SanPham sp\n" +
            "            \n" +
            "                        join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                        Join Image img on sp.Id = img.IdSP where img.isdefault = 'True'\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\tORDER BY sp.NgayThemSP DESC; \n" ,nativeQuery = true)
    List<SanPhamRepon> getAllSPNew();

    // findById Tên SP
    @Query(value = "select sp.Id,MaSP,TenSP,TheLoai , sp.GiaBan , img.TenImage   from SanPham sp\n" +
            "            \n" +
            "                                   join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                                   Join Image img on sp.Id = img.IdSP \n" +
            "                                   where img.isdefault = 'true'  AND sp.TenSP Like %:tensp%", nativeQuery = true)
    List<SanPhamRepon> findByNameSP(@Param("tensp") String tensp);

    // findById Danh Mục
    @Query(value = "select DISTINCT sp.Id,MaSP,TenSP,TheLoai , sp.GiaBan , img.TenImage  from SanPham sp\n" +
            "                                       \n" +
            "                           join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                           join DanhMuc dm on dm.Id = sp.IdDanhMuc\n" +
            "                           Join Image img on sp.Id = img.IdSP \n" +
            "              where img.isdefault = 'true' AND dm.Id = ?", nativeQuery = true)

    List<SanPhamRepon> findByIdDanhMuc(UUID iddm);


    // findById Size
    @Query(value = "select DISTINCT sp.Id,MaSP,TenSP,TheLoai , sp.GiaBan , img.TenImage   from SanPham sp\n" +
            "                                       \n" +
            "                           join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                           join Size s on ctsp.IdSize = s.Id\n" +
            "                           Join Image img on sp.Id = img.IdSP \n" +
            "              where img.isdefault = 'true' AND s.Id = ?", nativeQuery = true)
    List<SanPhamRepon> findByIdSize(UUID idsize);


}
