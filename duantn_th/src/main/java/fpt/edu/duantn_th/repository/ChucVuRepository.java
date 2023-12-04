package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.ChucVu;
import fpt.edu.duantn_th.enums.TypeAccountEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChucVuRepository extends JpaRepository<ChucVu,Long> {

    Optional<ChucVu> findByTenchucvu(TypeAccountEnum name);

}
