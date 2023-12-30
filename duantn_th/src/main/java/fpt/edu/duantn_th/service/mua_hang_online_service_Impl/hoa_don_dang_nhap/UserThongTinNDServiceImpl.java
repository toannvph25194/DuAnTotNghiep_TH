package fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.UserThongTinNDRepon;
import fpt.edu.duantn_th.entity.User;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.hoa_don_dang_nhap.UserThongTinNDRepository;
import fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_dang_nhap.UserThongTinNDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserThongTinNDServiceImpl implements UserThongTinNDService {

    @Autowired
    UserThongTinNDRepository thongTinNDRepository;

    @Override
    public UserThongTinNDRepon finByTaiKhoan(String taikhoan) {
        Optional<User> userOptional = thongTinNDRepository.findByTaikhoan(taikhoan);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserThongTinNDRepon userDto = new UserThongTinNDRepon();
            userDto.setTaikhoan(user.getTaikhoan());
            userDto.setHovaten(user.getHovaten());
            userDto.setSodienthoai(user.getSodienthoai());
            userDto.setEmail(user.getEmail());
            userDto.setNgaysinh(user.getNgaysinh());
            userDto.setGioitinh(user.getGioitinh());

            return userDto;
        } else {
            return null;
        }
    }
}
