package fpt.edu.duantn_th.service.Impl;


import fpt.edu.duantn_th.entity.DiaChi;
import fpt.edu.duantn_th.repository.DiaChiRepository;
import fpt.edu.duantn_th.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaChiServiceImpl implements DiaChiService {

    @Autowired
    DiaChiRepository repository;

    @Override
    public List<DiaChi> getALLDiaChi() {
        return repository.findAll();
    }
}
