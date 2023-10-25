package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
}
