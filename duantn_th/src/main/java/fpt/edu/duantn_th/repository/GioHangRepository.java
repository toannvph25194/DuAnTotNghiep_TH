package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.dto.respon.TimKiemIdGH;
import fpt.edu.duantn_th.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface GioHangRepository extends JpaRepository<GioHang, UUID> {

    // Kiểm tra xem tài khoản đã có id giohang với trạng thái bằng 1 hay chưa
    @Query(value = "SELECT gh.Id,IdTK,NgayTao,NgayCapNhat,GhiChu,TrangThai  FROM GioHang gh \n" +
            "              WHERE gh.IdTK = :idtk AND gh.TrangThai = :trangthai", nativeQuery = true)
    List<GioHang> findByUsers_IdtkAndTrangthai(@Param("idtk") UUID idtk, @Param("trangthai") Integer trangthai);

    // Tìm kiếm Id giohang theo Idtk và trangthai gh
    @Query(value = "SELECT  gh.Id ,gh.TrangThai FROM GioHang gh\n" +
            "INNER JOIN TaiKhoan tk on tk.Id = gh.IdTK\n" +
            "WHERE tk.Id = ? AND gh.TrangThai = 1", nativeQuery = true)
    TimKiemIdGH findByIdgiohang(UUID idtk);


}
