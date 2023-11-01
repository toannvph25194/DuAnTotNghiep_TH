package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.dto.respon.ChiTietSPRepon;
import fpt.edu.duantn_th.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham , UUID> {
}
