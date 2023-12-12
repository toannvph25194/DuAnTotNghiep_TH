package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
}
