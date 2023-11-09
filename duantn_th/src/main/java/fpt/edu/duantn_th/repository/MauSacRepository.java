package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
}
