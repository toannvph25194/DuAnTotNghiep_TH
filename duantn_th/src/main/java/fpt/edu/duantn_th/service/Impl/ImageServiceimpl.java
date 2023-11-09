package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.entity.Image;
import fpt.edu.duantn_th.entity.MauSac;
import fpt.edu.duantn_th.repository.ImageRepository;
import fpt.edu.duantn_th.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ImageServiceimpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;
    @Override
    public List<Image> getAllimg() {
        return imageRepository.findAll();
    }

    @Override
    public Image deleteimage(UUID idimg) {
        Image image = imageRepository.findById(idimg).orElse(null);
        imageRepository.delete(image);
        return image;
    }

    @Override
    public Image addimage(Image image) {
        return  imageRepository.save(image);
    }

    @Override
    public Image updateimage(Image image, UUID idimg) {
            Optional<Image> image1 = imageRepository.findById(idimg);

            return image1.map(o -> {

                o.setIdimage(image.getIdimage());
                o.setTrangthai(image.getTrangthai());

                return imageRepository.save(o);
            }).orElse(null);
    }
}
