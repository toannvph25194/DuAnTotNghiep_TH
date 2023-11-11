package fpt.edu.duantn_th.repository.not_login;

import fpt.edu.duantn_th.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiaChiRepository_not_login extends JpaRepository<DiaChi , UUID> {
}
