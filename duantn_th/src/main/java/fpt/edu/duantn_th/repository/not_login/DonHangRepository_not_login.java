package fpt.edu.duantn_th.repository.not_login;

import fpt.edu.duantn_th.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DonHangRepository_not_login extends JpaRepository<DonHang , UUID> {
}
