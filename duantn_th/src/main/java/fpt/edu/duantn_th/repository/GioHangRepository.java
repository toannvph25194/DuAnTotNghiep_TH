package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface GioHangRepository extends JpaRepository<GioHang, UUID> {

    @Query(value = "SELECT gh.Id,IdTK,NgayTao,NgayCapNhat,GhiChu,TrangThai  FROM GioHang gh \n" +
            "              WHERE gh.IdTK = :idtk AND gh.TrangThai = :trangthai", nativeQuery = true)
    List<GioHang> findByUsers_IdtkAndTrangthai(@Param("idtk") UUID idtk, @Param("trangthai") Integer trangthai);

}
