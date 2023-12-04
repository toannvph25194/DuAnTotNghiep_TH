package fpt.edu.duantn_th.service.Impl;
//import com.example.duantotnghiep.entity.TaiKhoan;
//import com.example.duantotnghiep.model.UserCustomDetails;
//import com.example.duantotnghiep.repository.TaiKhoanRepository;
import fpt.edu.duantn_th.entity.User;
import fpt.edu.duantn_th.jwt.UserCustomDetails;
import fpt.edu.duantn_th.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository phatTuRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> phatTu = phatTuRepository.findByTaikhoan(username);
        return new UserCustomDetails(phatTu.get());
    }
}
