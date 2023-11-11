package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.dto.respon.CheckoutRepon;
import fpt.edu.duantn_th.dto.respon.GioHangCTRepon;
import fpt.edu.duantn_th.dto.respon.TongSoTienRepo;
import fpt.edu.duantn_th.entity.ChiTietSanPham;
import fpt.edu.duantn_th.entity.GioHang;
import fpt.edu.duantn_th.entity.GioHangChiTiet;
import fpt.edu.duantn_th.repository.GioHangChiTietRepository;
import fpt.edu.duantn_th.repository.GioHangRepository;
import fpt.edu.duantn_th.service.GioHangCTService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@SessionScope
public class GioHangCTServiceImpl implements GioHangCTService {

    @Autowired
    GioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    GioHangRepository gioHangRepository;

    @Override
    public List<GioHangCTRepon> getALlGHCT(UUID idgh) {
        return gioHangChiTietRepository.getAllGhCT(idgh);
    }

    @Override
    public void addSPVaoGioHangCT( UUID idgiohang, UUID idctsp, Integer soluong) {

        // kiểm tra sản phẩm đã có trong giỏ hàng chi tiết chưa
        GioHangChiTiet ghct = gioHangChiTietRepository.findByGiohang_IdgiohangAndCtsp_Idctsp(idgiohang,idctsp);

        if (ghct != null){

            // Sản phẩm đã có trong giỏ hàng , cập nhật số lượng.
            ghct.setSoluong(ghct.getSoluong() + soluong);

            // Lấy đơn giá từ sản phẩm chi tiết
            ChiTietSanPham spct = ghct.getCtsp();
            if (spct != null) {
                ghct.setDongia(spct.getGiaban());
            }

            // Update vào giỏ hàng chi tiết
            gioHangChiTietRepository.save(ghct);

        }else {

            // Sản phẩm chưa có trong giỏ hàng thì thêm mới.
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setIdgiohangct(UUID.randomUUID());

            // Tạo mới đối tượng Giỏ Hàng để lấy id
            GioHang gh  = new GioHang();
            gh.setIdgiohang(idgiohang);
            gioHangChiTiet.setGiohang(gh);

            // Tạo mới đối tượng Sản Phẩm CT để lấy id
            ChiTietSanPham newspct  = new ChiTietSanPham();
            newspct.setIdctsp(idctsp);
            gioHangChiTiet.setCtsp(newspct);

            // Gét số lượng
            gioHangChiTiet.setSoluong(soluong);

            // Lấy đơn giá từ sản phẩm chi tiết
            Double giaban = newspct.getGiaban();
            if (giaban == null){
                gioHangChiTiet.setDongia(newspct.getGiaban());
            }


            // Add Giỏ Hàng Chi Tiết
            gioHangChiTietRepository.save(gioHangChiTiet);
        }


    }

    @Override
    public GioHangChiTiet updateGHCT(UUID idghct, Integer soluong) {
        GioHangChiTiet ghct = gioHangChiTietRepository.findById(idghct).orElse(null);

        if (ghct != null){
            ghct.setSoluong(soluong);
            gioHangChiTietRepository.save(ghct);
        }else {
            throw new EntityNotFoundException("Id không có trong giỏ hàng !");
        }
        return ghct;
    }

    @Override
    public GioHangChiTiet deleteSPGHCT(UUID idghct) {
        GioHangChiTiet ghct = gioHangChiTietRepository.findById(idghct).orElse(null);
        if (ghct != null){
            gioHangChiTietRepository.delete(ghct);
        }else {
            throw new EntityNotFoundException();
        }
        return ghct;
    }

    @Override
    public void deleteALlSPGHCT(UUID idgiohang) {

        // Tìm giỏ hàng dựa trên idgiohang
        Optional<GioHang> gioHangOptional = gioHangRepository.findById(idgiohang);

        if (gioHangOptional.isPresent()) {
            GioHang gioHang = gioHangOptional.get();

            // Lấy danh sách chi tiết giỏ hàng
            List<GioHangChiTiet> chiTietList = gioHang.getGhct();

            // Xóa tất cả chi tiết giỏ hàng
            for (GioHangChiTiet chiTiet : chiTietList) {
                gioHangChiTietRepository.delete(chiTiet);
            }

            // Cập nhật lại giỏ hàng sau khi xóa
            gioHang.setGhct(new ArrayList<>()); // Đặt lại danh sách chi tiết giỏ hàng thành rỗng
            gioHangRepository.save(gioHang);

        }else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<CheckoutRepon> getAllTongTien(UUID idgiohang) {
        return gioHangChiTietRepository.getAllTongTien(idgiohang);
    }

    @Override
    public List<TongSoTienRepo> getTongSoTien(UUID idgiohang) {
        return gioHangChiTietRepository.getTongSoTien(idgiohang);
    }
}
