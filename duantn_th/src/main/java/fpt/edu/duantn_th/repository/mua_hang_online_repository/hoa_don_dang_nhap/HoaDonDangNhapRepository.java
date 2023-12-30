package fpt.edu.duantn_th.repository.mua_hang_online_repository.hoa_don_dang_nhap;

import fpt.edu.duantn_th.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonDangNhapRepository extends JpaRepository<HoaDon , UUID> {
}
