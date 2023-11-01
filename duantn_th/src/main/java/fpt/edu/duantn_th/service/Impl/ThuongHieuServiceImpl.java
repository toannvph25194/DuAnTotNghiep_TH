package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.entity.ThuongHieu;
import fpt.edu.duantn_th.repository.ThuongHieuRepository;
import fpt.edu.duantn_th.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {

    @Autowired
    ThuongHieuRepository repository;

    @Override
    public List<ThuongHieu> getAllThuongHieu() {
        return repository.findAll();
    }

    @Override
    public ThuongHieu deletethuonghieu(UUID idthuonghieu) {
        ThuongHieu th = repository.findById(idthuonghieu).orElse(null);
        repository.delete(th);
        return th;
    }

    @Override
    public ThuongHieu addthuonghieu(ThuongHieu th) {
        return repository.save(th);
    }

    @Override
    public ThuongHieu updatethuonghieu(ThuongHieu th, UUID idthuonghieu) {
        Optional<ThuongHieu> thuongHieu = repository.findById(idthuonghieu);

        return thuongHieu.map(o -> {

            o.setTenthuonghieu(th.getTenthuonghieu());
            o.setTrangthai(th.getTrangthai());

            return repository.save(o);
        }).orElse(null);
    }
}
