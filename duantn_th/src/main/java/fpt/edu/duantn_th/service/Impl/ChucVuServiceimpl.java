package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.entity.ChucVu;
import fpt.edu.duantn_th.repository.ChucVuRepository;
import fpt.edu.duantn_th.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ChucVuServiceimpl implements ChucVuService {

    @Autowired
    ChucVuRepository repository;

    // Show data
    @Override
    public List<ChucVu> getAllchucvu() {
        return repository.findAll();
    }

    // delete
    @Override
    public ChucVu deletechucvu(Long idcv) {
        ChucVu cv = repository.findById(idcv).orElse(null);
        repository.delete(cv);
        return cv;
    }

    // add
    @Override
    public ChucVu addchucvu(ChucVu cv) {
        return repository.save(cv);
    }

    // update
    @Override
    public ChucVu updatechucvu(ChucVu chucvu, Long idcv) {
        Optional<ChucVu> cv = repository.findById(idcv);

        return cv.map(o -> {

            o.setTenchucvu(chucvu.getTenchucvu());
            o.setTrangthai(chucvu.getTrangthai());

            return repository.save(o);
        }).orElse(null);

    }


}
