package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.entity.ChucVu;
import fpt.edu.duantn_th.entity.MauSac;
import fpt.edu.duantn_th.repository.MauSacRepository;
import fpt.edu.duantn_th.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class MauSacServiceimpl implements MauSacService {
    @Autowired
    MauSacRepository mauSacRepository;
    @Override
    public List<MauSac> getAllmausac() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac deletemausac(UUID idms) {
        MauSac ms = mauSacRepository.findById(idms).orElse(null);
        mauSacRepository.delete(ms);
        return ms;
    }

    @Override
    public MauSac addmausac(MauSac ms) {
        return  mauSacRepository.save(ms);
    }

    @Override
    public MauSac updatemausac(MauSac ms, UUID idms) {
        Optional<MauSac> mauSac = mauSacRepository.findById(idms);

        return mauSac.map(o -> {

            o.setTenmausac(ms.getTenmausac());
            o.setTrangthai(ms.getTrangthai());

            return mauSacRepository.save(o);
        }).orElse(null);

    }
}
