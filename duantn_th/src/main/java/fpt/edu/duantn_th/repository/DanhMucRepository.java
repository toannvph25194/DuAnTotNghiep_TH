package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DanhMucRepository extends JpaRepository<DanhMuc, UUID> {
}
