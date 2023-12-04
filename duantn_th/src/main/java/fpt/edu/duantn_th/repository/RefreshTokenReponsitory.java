package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.Refeshtoken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenReponsitory extends JpaRepository<Refeshtoken, UUID>{

    Optional<Refeshtoken> findByToken(String token);

}