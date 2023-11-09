package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatLieuRepository extends JpaRepository<ChatLieu, UUID> {
}
