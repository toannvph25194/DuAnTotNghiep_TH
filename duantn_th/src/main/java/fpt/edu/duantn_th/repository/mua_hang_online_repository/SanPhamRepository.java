package fpt.edu.duantn_th.repository.mua_hang_online_repository;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.DanhMucShopRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.MauSacShopRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.SanPhamRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.SizeShopRepon;
import fpt.edu.duantn_th.entity.DanhMuc;
import fpt.edu.duantn_th.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham , UUID> {

    // getALl PT sản phẩm shop 1 ảnh
    @Query(value = "SELECT COUNT(DISTINCT sp.Id) , sp.Id,MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage \n" +
            "FROM SanPham sp\n" +
            "JOIN Image img ON sp.Id = img.IdSP \n" +
            "JOIN ChiTietSP ctsp ON ctsp.IdSP = sp.Id\n" +
            "WHERE img.isdefault = 'TRUE' AND ctsp.SoLuongTon > 0 \n" +
            "GROUP BY sp.Id, sp.MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage", nativeQuery = true)
    Page<SanPhamRepon> getAllSPShop(Pageable pageable);


    // getALl sản phẩm home 1 ảnh
    @Query(value ="SELECT COUNT(DISTINCT sp.Id) , sp.Id,MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage\n" +
            "            FROM SanPham sp\n" +
            "            JOIN Image img ON sp.Id = img.IdSP \n" +
            "            JOIN ChiTietSP ctsp ON ctsp.IdSP = sp.Id\n" +
            "            WHERE img.isdefault = 'TRUE' AND ctsp.SoLuongTon > 0 \n" +
            "            GROUP BY sp.Id, sp.MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage" ,nativeQuery = true)
    Page<SanPhamRepon> getAllSPHome(Pageable pageable);

    // getALl sản phẩm của nam và 1 ảnh
    @Query(value ="SELECT COUNT(DISTINCT sp.Id) , sp.Id,MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage\n" +
            "            FROM SanPham sp\n" +
            "            JOIN Image img ON sp.Id = img.IdSP \n" +
            "            JOIN ChiTietSP ctsp ON ctsp.IdSP = sp.Id\n" +
            "            WHERE img.isdefault = 'TRUE' AND sp.TheLoai = 'TRUE' AND ctsp.SoLuongTon > 0 \n" +
            "            GROUP BY sp.Id, sp.MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage" ,nativeQuery = true)
    Page<SanPhamRepon> getAllSPNam(Pageable pageable);

    // getALl sản phẩm của nữ và 1 ảnh
    @Query(value ="SELECT COUNT(DISTINCT sp.Id) , sp.Id,MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage\n" +
            "            FROM SanPham sp\n" +
            "            JOIN Image img ON sp.Id = img.IdSP \n" +
            "            JOIN ChiTietSP ctsp ON ctsp.IdSP = sp.Id\n" +
            "            WHERE img.isdefault = 'TRUE' AND sp.TheLoai = 'FALSE' AND ctsp.SoLuongTon > 0 \n" +
            "            GROUP BY sp.Id, sp.MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage" ,nativeQuery = true)
    Page<SanPhamRepon> getAllSPNu(Pageable pageable);

    // getALl sản phẩm mới nhất và 1 ảnh
    @Query(value ="SELECT DISTINCT TOP 6 sp.Id,MaSP,TenSP,TheLoai,NgayThemSP ,sp.GiaBan , img.TenImage  from SanPham sp\n" +
            "            \n" +
            "                        join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                        Join Image img on sp.Id = img.IdSP where img.isdefault = 'True' AND ctsp.SoLuongTon > 0 \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\tORDER BY sp.NgayThemSP DESC; \n" ,nativeQuery = true)
    List<SanPhamRepon> getAllSPNew();

    // findById Tên SP
    @Query(value = "select COUNT(DISTINCT sp.Id) , sp.Id,MaSP,TenSP,TheLoai , sp.GiaBan , img.TenImage   from SanPham sp\n" +
            "            \n" +
            "                                   join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                                   Join Image img on sp.Id = img.IdSP \n" +
            "                                   where img.isdefault = 'true'  AND sp.TenSP Like %:tensp%  " +
            "                                   GROUP BY sp.Id, sp.MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage", nativeQuery = true)
    List<SanPhamRepon> findByNameSP(Pageable pageable ,@Param("tensp") String tensp);

    // getAll Danh Mục Theo Trạng Thái
    @Query(value = "select * from DanhMuc where TrangThai = 1",nativeQuery = true)
    List<DanhMucShopRepon> getAllByDMTrangthai();

    // Tìm Kiếm Danh  Mục Theo Tên Danh Mục
    @Query(value = "SELECT sp.Id, sp.MaSP, sp.TenSP, sp.GiaBan, sp.TheLoai, img.TenImage from DanhMuc dm\n" +
            "            \n" +
            "            join SanPham sp on sp.IdDanhMuc = dm.Id\n" +
            "            Join Image img on sp.Id = img.IdSP\n" +
            "            where img.isdefault = 'true' AND dm.TenDanhMuc Like %:tendanhmuc%", nativeQuery = true)
    Page<SanPhamRepon> finByNameDanhMuc(Pageable pageable , @Param("tendanhmuc") String tendanhmuc);


    // getAll Size Theo Trạng Thái
    @Query(value = "select * from SIZE where TrangThai = 1",nativeQuery = true)
    List<SizeShopRepon> getAllBySizeTrangthai();

    // findById Size
    @Query(value = "SELECT COUNT(DISTINCT sp.Id) , sp.Id, sp.MaSP, sp.TenSP, sp.GiaBan, sp.TheLoai, img.TenImage from SanPham sp\n" +
            "            \n" +
            "                        join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                        Join Image img on sp.Id = img.IdSP\n" +
            "\t\t\t\t\t\t            Join Size s on s.Id = ctsp.IdSize\n" +
            "                        where img.isdefault = 'true' AND s.TenSize Like %:tensize%   " +
            "                        GROUP BY sp.Id, sp.MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage", nativeQuery = true)
    Page<SanPhamRepon> findByNameSize(Pageable pageable , @Param("tensize") String tensize);

    // getAll Màu Sắc Theo Trạng Thái
    @Query(value = "select * from MauSac where TrangThai = 1",nativeQuery = true)
    List<MauSacShopRepon> getAllByMauSacTrangthai();

    // findById Màu Sắc
    @Query(value = "SELECT COUNT(DISTINCT sp.Id) , sp.Id, sp.MaSP, sp.TenSP, sp.GiaBan, sp.TheLoai, img.TenImage from SanPham sp\n" +
            "            \n" +
            "                        join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                        Join Image img on sp.Id = img.IdSP\n" +
            "\t\t\t\t\t\t            Join MauSac ms on ms.Id = ctsp.IdMauSac\n" +
            "                        where img.isdefault = 'true' AND ms.TenMauSac Like %:tenmausac%   " +
            "                        GROUP BY sp.Id, sp.MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage", nativeQuery = true)
    Page<SanPhamRepon> findByMauSac(Pageable pageable , @Param("tenmausac") String tensize);

    // findById Theo Giá
    @Query(value = "SELECT COUNT(DISTINCT sp.Id) , sp.Id, sp.MaSP, sp.TenSP, sp.GiaBan, sp.TheLoai, img.TenImage from SanPham sp\n" +
            "            \n" +
            "                                    join ChiTietSP ctsp on ctsp.IdSP = sp.Id\n" +
            "                                    Join Image img on sp.Id = img.IdSP\n" +
            "\t\t\t\t\t\t            Join MauSac ms on ms.Id = ctsp.IdMauSac\n" +
            "                                    where img.isdefault = 'true' AND sp.GiaBan BETWEEN :key1 AND :key2  \n" +
            "                                    GROUP BY sp.Id, sp.MaSP, sp.TenSP, sp.TheLoai, sp.GiaBan, img.TenImage", nativeQuery = true)
    Page<SanPhamRepon> findByGiaSP(Pageable pageable , @Param("key1") Double key1 , @Param("key2") Double key2);
}
