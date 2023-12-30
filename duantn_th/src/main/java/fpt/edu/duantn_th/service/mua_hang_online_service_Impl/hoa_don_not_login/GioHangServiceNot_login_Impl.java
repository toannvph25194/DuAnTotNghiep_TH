package fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_not_login;

import fpt.edu.duantn_th.entity.GioHang;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.GioHangRepository;
import fpt.edu.duantn_th.repository.UserRepository;
import fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_not_login.GioHangServie_Not_Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GioHangServiceNot_login_Impl implements GioHangServie_Not_Login {

    @Autowired
    GioHangRepository repository;

    @Autowired
    UserRepository userRepository;


    @Override
    public GioHang createGioHang(GioHang gh) {


            GioHang giohang = new GioHang();
            giohang.setIdgiohang(UUID.randomUUID());
            giohang.setUsers(null);
            giohang.setNgaytao(gh.getNgaytao());
            giohang.setNgaycapnhat(gh.getNgaycapnhat());
            giohang.setGhichu(gh.getGhichu());
            giohang.setTrangthai(1);

            return repository.save(giohang);
    }
}
