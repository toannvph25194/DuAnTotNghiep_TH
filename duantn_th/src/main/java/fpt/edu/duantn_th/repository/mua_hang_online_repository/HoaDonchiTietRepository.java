package fpt.edu.duantn_th.repository.mua_hang_online_repository;

import fpt.edu.duantn_th.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonchiTietRepository extends JpaRepository<HoaDonChiTiet , UUID> {
}
