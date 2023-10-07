package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiaChiRepository extends JpaRepository<DiaChi, UUID> {
}
