package fpt.edu.duantn_th.repository.mua_hang_online_repository.hoa_don_dang_nhap;

import fpt.edu.duantn_th.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserThongTinNDRepository extends JpaRepository<User , UUID> {

    // Lấy thông tin người dùng qua taikhoan
    Optional<User> findByTaikhoan(String taikhoan);

}
