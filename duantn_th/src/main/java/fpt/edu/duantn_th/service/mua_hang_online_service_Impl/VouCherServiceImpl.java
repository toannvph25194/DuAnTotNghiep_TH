package fpt.edu.duantn_th.service.mua_hang_online_service_Impl;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.VouCherOnlineRepon;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.VouCherRepository;
import fpt.edu.duantn_th.service.mua_hang_online_service.VouCherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VouCherServiceImpl implements VouCherService {

    @Autowired
    VouCherRepository vouCherRepository;

    @Override
    public List<VouCherOnlineRepon> getALlVouCher() {
        return vouCherRepository.getALlVouCher();
    }
}
