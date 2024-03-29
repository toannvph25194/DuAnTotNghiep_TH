package fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_not_login;

import fpt.edu.duantn_th.dto.request.mua_hang_online_request.not_login.Create_Khach_Hang_Not_login;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.not_login.MessageThanhToanRepon_not_login;

import fpt.edu.duantn_th.entity.*;
import fpt.edu.duantn_th.enums.StatusOrderEnums;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.HinhThucThanhToanRepository;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.VouCherRepository;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.hoa_don_not_login.*;
import fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_not_login.HoaDonNot_Login_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class HoaDonService_Not_Login_Impl implements HoaDonNot_Login_Service {

    @Autowired
    UserRepository_not_login userRepository_not_login;

    @Autowired
    DiaChiRepository_not_login diaChiRepository_not_login;

    @Autowired
    HoaDonRepository_not_login donHangRepository_not_login;

    @Autowired
    GioHangChiTietRepository_not_login gioHangChiTietRepository_not_login;

    @Autowired
    HoaDonChiTietRepository_not_login hoaDonChiTietRepository_not_login;

    @Autowired
    GioHangRepository_not_login gioHangRepository_not_login;

    @Autowired
    VouCherRepository vouCherRepository;

    @Autowired
    HinhThucThanhToanRepository hinhThucThanhToanRepository;

    @Override
    public MessageThanhToanRepon_not_login thanhToanKhongDangNhap(Create_Khach_Hang_Not_login create_khach_hang_not_login) {

        List<User> userList = userRepository_not_login.getKhachHangByEmailAndSdt(create_khach_hang_not_login.getEmail(), create_khach_hang_not_login.getSodienthoai());
        User khachhang ;

        Optional<VouCher> vouCher = vouCherRepository.findById(create_khach_hang_not_login.getIdvoucher());

        //Step1 : Xử lí khách hàng và địa chỉ
        if (!userList.isEmpty()){
            // Nếu tài khoản khách hàng đã tồn tại, sử dụng tài khoản đó.
            khachhang = userList.get(0);
        }else {
                // Nếu không tìm thấy tài khoản, tạo tài khoản mới cho khách hàng.
                khachhang = new User();

                khachhang.setIdtk(UUID.randomUUID());
                khachhang.setEmail(create_khach_hang_not_login.getEmail());
                khachhang.setHovaten(create_khach_hang_not_login.getHovaten());
                khachhang.setSodienthoai(create_khach_hang_not_login.getSodienthoai());
                khachhang.setTrangthai(0);
                userRepository_not_login.save(khachhang);

                // Tạo Địa Chỉ Cho Khách Hàng
                DiaChi diaChi = new DiaChi();

                diaChi.setIddiachi(UUID.randomUUID());
                diaChi.setDiachi(create_khach_hang_not_login.getDiachi());
                diaChi.setQuocgia("Việt Nam");
                diaChi.setTinh(create_khach_hang_not_login.getTinh());
                diaChi.setHuyen(create_khach_hang_not_login.getHuyen());
                diaChi.setXa(create_khach_hang_not_login.getXa());
                diaChi.setTrangthai(1);
                diaChi.setUsers(khachhang);
                diaChiRepository_not_login.save(diaChi);
            }



        //Step2 : Xử lí hóa đơn
        // Tạo hóa đơn mới và gán thông tin tài khoản khách hàng.
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Random rand = new Random();
        int randomNumber = rand.nextInt(100000);
        String maHd = String.format("HD%03d", randomNumber);

        HoaDon hoadon = new HoaDon();

        hoadon.setIdhoadon(UUID.randomUUID());
        hoadon.setMadonhang(maHd);
        hoadon.setNgaytao(timestamp);
        hoadon.setDiachi(create_khach_hang_not_login.getDiachi() +" "+ create_khach_hang_not_login.getXa() +" "+create_khach_hang_not_login.getHuyen() +" "+create_khach_hang_not_login.getTinh());
        hoadon.setSdtnguoinhan(create_khach_hang_not_login.getSodienthoai());
        hoadon.setTennguoinhan(create_khach_hang_not_login.getHovaten());
        hoadon.setUsers(khachhang);
        hoadon.setThanhtien(create_khach_hang_not_login.getTongTien());
        hoadon.setTienkhachtra(create_khach_hang_not_login.getTienKhachTra());
//        donHang.setTienthua(create_khach_hang_not_login.getTienKhachTra() - create_khach_hang_not_login.getTongTien().doubleValue());

        hoadon.setGiatrigiam(create_khach_hang_not_login.getGiatrigiam());
        // Check Nếu IdVouCher Là Null thì Sẽ K Lưu
        if (vouCher.isPresent()) {
            hoadon.setVoucher(vouCher.get());
            vouCher.get().setSoluongdung(vouCher.get().getSoluongdung() + 1);

            // Save Vào cơ sở dữ liệu
            vouCherRepository.save(vouCher.get());
        }

        hoadon.setTrangthai(StatusOrderEnums.CHO_XAC_NHAN.getValue());
        donHangRepository_not_login.save(hoadon);

        // Sử Lý Hình Thức Thanh Toán
        if (create_khach_hang_not_login.getPhuongThucThanhToan() == 1){
            HinhThucThanhToan hinhthucTT = new HinhThucThanhToan();
            hinhthucTT.setIdhtthanhtoan(UUID.randomUUID());
            hinhthucTT.setHoadon(hoadon);
            hinhthucTT.setNgaythanhtoan(new Date(System.currentTimeMillis()));
            hinhthucTT.setSotientra(create_khach_hang_not_login.getTongTien());
            hinhthucTT.setPhuongthucthanhtoan(create_khach_hang_not_login.getPhuongThucThanhToan());
            hinhthucTT.setTrangthai(1);
            hinhThucThanhToanRepository.save(hinhthucTT);
        }


        //Step3 : Xử lí hóa đơn chi tiết
        for (UUID idGioHangCT : create_khach_hang_not_login.getGioHangChiTietList()){
            // Tạo chi tiết hóa đơn cho mỗi sản phẩm trong giỏ hàng.

            Optional<GioHangChiTiet> gioHangChiTiet = gioHangChiTietRepository_not_login.findById(idGioHangCT);

            if (gioHangChiTiet.isPresent()){

                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setIdhoadonct(UUID.randomUUID());

                hdct.setHoadon(hoadon);
                hdct.setCtsp(gioHangChiTiet.get().getCtsp());
                hdct.setSoluong(gioHangChiTiet.get().getSoluong());
                hdct.setDongia(gioHangChiTiet.get().getCtsp().getSanpham().getGiaban());

                hdct.setTrangthai(1);

                hoaDonChiTietRepository_not_login.save(hdct);

            }else {
                System.out.println("Giỏ Hàng Chi Tiết K Tồn Tại");
                return MessageThanhToanRepon_not_login.builder().message("Thanh Toán Thất Bại !").build();
            }

        }

        //Step 4 : Cập nhật trạng thái của giỏ hàng thành 2 sau khi thanh toán
        for (UUID idGioHangChiTiet : create_khach_hang_not_login.getGioHangChiTietList()) {

            Optional<GioHangChiTiet> gioHangChiTiet = gioHangChiTietRepository_not_login.findById(idGioHangChiTiet);

            if (gioHangChiTiet.isPresent()) {
                System.out.println(gioHangChiTiet.get().getGiohang().getTrangthai());
                gioHangChiTiet.get().getGiohang().setTrangthai(2);
                gioHangRepository_not_login.save(gioHangChiTiet.get().getGiohang());
            }

        }

        //Step 5 : Đặt số lượng tất cả các sản phẩm trong giỏ hàng về 0
        for (UUID idGioHangChiTiet : create_khach_hang_not_login.getGioHangChiTietList()) {

            Optional<GioHangChiTiet> gioHangChiTiet = gioHangChiTietRepository_not_login.findById(idGioHangChiTiet);

            if (gioHangChiTiet.isPresent()) {
                gioHangChiTiet.get().setSoluong(0);
                gioHangChiTietRepository_not_login.save(gioHangChiTiet.get());
            }

        }

        return MessageThanhToanRepon_not_login.builder().message("Thanh Toán Thành Công").idhoadon(hoadon.getIdhoadon()).build();
    }
}
