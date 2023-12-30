package fpt.edu.duantn_th.service.mua_hang_online_service_Impl;


import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.*;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.ChiTietSanPhamRepository;
import fpt.edu.duantn_th.service.mua_hang_online_service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    ChiTietSanPhamRepository repository;

    @Override
    public ChiTietSPRepon detailSP(UUID idsp) {
        return repository.detailSP(idsp);
    }

    @Override
    public List<SanPhamRepon> getAllSPNewTaiCTSP() {
        return repository.getAllSPNewTaiCTSP();
    }

    @Override
    public TongSoLuongSPRepon loadTongSoLuongSP(UUID idsp) {
        return repository.loadTongSoLuongSP(idsp);
    }

    @Override
    public List<DetailSizeRepon> detailSize(UUID idsp) {
        return repository.detailSize(idsp);
    }

    @Override
    public List<DetailMauSacRepon> detailMauSac(UUID idsp) {
        return repository.detailMauSac(idsp);
    }

    @Override
    public List<TimKiemSizeRepon> timkiemSize(UUID idsp, UUID idmausac) {
        return repository.timKiemSize(idsp,idmausac);

    }

    @Override
    public List<TimKiemMauSacRepon> timkiemMauSac(UUID idsp, UUID idsize) {
        return repository.timKiemMauSac(idsp,idsize);
    }

    @Override
    public TimKiemIDCTSPRepon timkiemIdCTSP(UUID idsp, UUID idmausac, UUID idsize) {
        return repository.timkiemIdCTSP(idsp,idmausac,idsize);
    }
}
