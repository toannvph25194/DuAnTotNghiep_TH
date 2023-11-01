package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.XuatXu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface XuatXuRepository extends JpaRepository<XuatXu, UUID> {
}
