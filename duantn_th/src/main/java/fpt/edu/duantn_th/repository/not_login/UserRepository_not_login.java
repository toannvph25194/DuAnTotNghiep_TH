package fpt.edu.duantn_th.repository.not_login;

import fpt.edu.duantn_th.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository_not_login extends JpaRepository<User, UUID> {
    @Query(value = "SELECT * FROM TaiKhoan where Email = ? AND sodienthoai = ?",nativeQuery = true)
    List<User> getKhachHangByEmailAndSdt(String email, String sodienthoai);
}
