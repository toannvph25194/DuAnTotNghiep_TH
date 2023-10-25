package fpt.edu.duantn_th.repository;

import fpt.edu.duantn_th.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>{
}
