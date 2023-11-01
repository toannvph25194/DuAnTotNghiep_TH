package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.entity.DanhMuc;
import fpt.edu.duantn_th.repository.DanhMucRepository;
import fpt.edu.duantn_th.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    DanhMucRepository repository;

    @Override
    public List<DanhMuc> getAllDanhMuc() {
        return repository.findAll();
    }

    @Override
    public DanhMuc deletedanhmuc(UUID iddm) {
        DanhMuc dm = repository.findById(iddm).orElse(null);
        repository.delete(dm);
        return dm;
    }

    @Override
    public DanhMuc adddanhmuc(DanhMuc iddm) {
        return repository.save(iddm);
    }

    @Override
    public DanhMuc updatedanhmuc(DanhMuc dm, UUID iddm) {
        Optional<DanhMuc> danhMuc = repository.findById(iddm);

        return danhMuc.map(o -> {

            o.setTendanhmuc(dm.getTendanhmuc());
            o.setTrangthai(dm.getTrangthai());

            return repository.save(o);
        }).orElse(null);
    }
}
