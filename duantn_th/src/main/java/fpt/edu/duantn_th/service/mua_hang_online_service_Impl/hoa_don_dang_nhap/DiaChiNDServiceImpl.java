package fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.DiaChiNDRepon;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.hoa_don_dang_nhap.DiaChiNguoiDungRepository;
import fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_dang_nhap.DiaChiNDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaChiNDServiceImpl implements DiaChiNDService {

    @Autowired
    DiaChiNguoiDungRepository diaChiNguoiDungRepository;

    @Override
    public List<DiaChiNDRepon> getAllDiaChiND(String tdaikhoan) {
        return diaChiNguoiDungRepository.getAllDiaChiND(tdaikhoan);
    }
}
