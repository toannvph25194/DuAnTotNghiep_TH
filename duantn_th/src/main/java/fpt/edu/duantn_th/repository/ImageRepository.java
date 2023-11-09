package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository  extends JpaRepository<Image, UUID> {
}
