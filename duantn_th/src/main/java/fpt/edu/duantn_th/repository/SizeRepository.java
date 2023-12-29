package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SizeRepository  extends JpaRepository<Size , UUID> {
}
