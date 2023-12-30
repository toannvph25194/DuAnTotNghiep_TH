package fpt.edu.duantn_th.service.mua_hang_online_service_Impl;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.CheckoutRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.GioHangCTRepon;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.TongSoTienRepon;
import fpt.edu.duantn_th.entity.ChiTietSanPham;
import fpt.edu.duantn_th.entity.GioHang;
import fpt.edu.duantn_th.entity.GioHangChiTiet;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.ChiTietSanPhamRepository;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.GioHangChiTietRepository;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.GioHangRepository;
import fpt.edu.duantn_th.service.mua_hang_online_service.GioHangCTService;
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

    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<GioHangCTRepon> getALlGHCT(UUID idgiohang) {
        return gioHangChiTietRepository.getAllGhCT(idgiohang);
    }

    @Override
    public void addSPVaoGioHangCT(UUID idgiohang, UUID idctsp, Integer soluong) {

        // kiểm tra sản phẩm đã có trong giỏ hàng chi tiết chưa
        GioHangChiTiet ghct = gioHangChiTietRepository.findByGiohang_IdgiohangAndCtsp_Idctsp(idgiohang,idctsp);
        ChiTietSanPham ctspupdatesoluong = chiTietSanPhamRepository.findById(idctsp).orElse(null);
        if (ghct != null){

            // Sản phẩm đã có trong giỏ hàng , cập nhật số lượng.
            ghct.setSoluong(ghct.getSoluong() + soluong);

            // Update vào giỏ hàng chi tiết
            gioHangChiTietRepository.save(ghct);

            // Giảm số lượng của sản phẩm chi tiết
            ctspupdatesoluong.setSoluongton(ctspupdatesoluong.getSoluongton() - soluong);
            chiTietSanPhamRepository.save(ctspupdatesoluong);

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

            // Add Giỏ Hàng Chi Tiết
            gioHangChiTietRepository.save(gioHangChiTiet);

            // Giảm số lượng của sản phẩm chi tiết
            ctspupdatesoluong.setSoluongton(ctspupdatesoluong.getSoluongton() - soluong);
            chiTietSanPhamRepository.save(ctspupdatesoluong);
        }
    }

    @Override
    public GioHangChiTiet updateGHCT(UUID idghct, Integer soluong) {
        GioHangChiTiet ghct = gioHangChiTietRepository.findById(idghct).orElse(null);

        if (ghct != null){

            // Số lượng cũ trong giỏ hàng
            Integer soLuongCu = ghct.getSoluong();

            // Số lượng hiện tại trong kho của ctsp
            Integer soLuongTonKho = ghct.getCtsp().getSoluongton();

            // Xử lý tình huống khi số lượng mới nhỏ hơn hoặc bằng số lượng hiện tại trong kho
            // Số lượng thay đổi
            Integer soLuongThayDoi = soluong - soLuongCu;

            ghct.setSoluong(soluong);

            // Cập nhật số lượng trong kho bằng cách cộng số lượng thay đổi
            Integer soLuongMoiTonKho = soLuongTonKho - soLuongThayDoi;
            ghct.getCtsp().setSoluongton(soLuongMoiTonKho);
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

            // Cập Nhật lại số lượng tồn trong ctsp
            ChiTietSanPham ctsp = ghct.getCtsp();
            if (ctsp != null){
                ctsp.setSoluongton(ctsp.getSoluongton() + ghct.getSoluong());
                chiTietSanPhamRepository.save(ctsp);
            }

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

                ChiTietSanPham ctsp = chiTiet.getCtsp();
                if (ctsp != null){
                    ctsp.setSoluongton(ctsp.getSoluongton() + chiTiet.getSoluong());
                    chiTietSanPhamRepository.save(ctsp);
                }
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
    public List<TongSoTienRepon> getTongSoTien(UUID idgiohang) {
        return gioHangChiTietRepository.getTongSoTien(idgiohang);
    }
}
