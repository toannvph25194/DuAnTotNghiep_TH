package fpt.edu.duantn_th.repository.not_login;

import fpt.edu.duantn_th.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangChiTietRepository_not_login extends JpaRepository<GioHangChiTiet , UUID> {
}
