package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.entity.XuatXu;
import fpt.edu.duantn_th.repository.XuatXuRepository;
import fpt.edu.duantn_th.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class XuatXuServiceIpml implements XuatXuService {

    @Autowired
    XuatXuRepository repository;

    @Override
    public List<XuatXu> getAllXuatXu() {
        return repository.findAll();
    }

    @Override
    public XuatXu deletexuatxu(UUID idxuatxu) {
        XuatXu xx = repository.findById(idxuatxu).orElse(null);
        repository.delete(xx);
        return xx;
    }

    @Override
    public XuatXu addxuatxu(XuatXu xx) {
        return repository.save(xx);
    }

    @Override
    public XuatXu updatexuatxu(XuatXu xx, UUID idxuatxu) {
        Optional<XuatXu> xuatXu = repository.findById(idxuatxu);

        return xuatXu.map(o -> {

            o.setTenxuatxu(xx.getTenxuatxu());
            o.setTrangthai(xx.getTrangthai());

            return repository.save(o);
        }).orElse(null);
    }
}
