package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.entity.MauSac;
import fpt.edu.duantn_th.entity.Size;
import fpt.edu.duantn_th.repository.SizeRepository;
import fpt.edu.duantn_th.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class SizeServiceimpl implements SizeService {
    @Autowired
    SizeRepository sizeRepository;

    @Override
    public List<Size> getAllsize() {
        return sizeRepository.findAll();
    }

    @Override
    public Size deletesize(UUID idsz) {
        Size sz = sizeRepository.findById(idsz).orElse(null);
        sizeRepository.delete(sz);
        return sz;
    }

    @Override
    public Size addsize(Size sz) {
        return  sizeRepository.save(sz);
    }

    @Override
    public Size updatesize(Size sz, UUID idsz) {
        Optional<Size> size = sizeRepository.findById(idsz);

        return size.map(o -> {

            o.setTensize(sz.getTensize());
            o.setTrangthai(sz.getTrangthai());

            return sizeRepository.save(o);
        }).orElse(null);
    }
}
