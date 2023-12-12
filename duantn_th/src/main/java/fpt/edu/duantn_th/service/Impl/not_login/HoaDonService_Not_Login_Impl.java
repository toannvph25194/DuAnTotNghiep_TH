package fpt.edu.duantn_th.service.Impl.not_login;

import fpt.edu.duantn_th.dto.request.not_login.Create_Khach_Hang_Not_login;
import fpt.edu.duantn_th.dto.respon.not_login.MessageThanhToanRepon_not_login;

import fpt.edu.duantn_th.entity.*;
import fpt.edu.duantn_th.enums.StatusOrderEnums;
import fpt.edu.duantn_th.repository.not_login.*;
import fpt.edu.duantn_th.service.not_login.HoaDonNot_Login_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public MessageThanhToanRepon_not_login thanhToanKhongDangNhap(Create_Khach_Hang_Not_login create_khach_hang_not_login) {

        List<User> userList = userRepository_not_login.getKhachHangByEmailAndSdt(create_khach_hang_not_login.getEmail(), create_khach_hang_not_login.getSoDienThoai());
        User khachhang ;

        //Step1 : Xử lí khách hàng và địa chỉ
        if (!userList.isEmpty()){
            // Nếu tài khoản khách hàng đã tồn tại, sử dụng tài khoản đó.
            khachhang = userList.get(0);
        }else {
                // Nếu không tìm thấy tài khoản, tạo tài khoản mới cho khách hàng.
                khachhang = new User();

                khachhang.setIdtk(UUID.randomUUID());
                khachhang.setEmail(create_khach_hang_not_login.getEmail());
                khachhang.setHovaten(create_khach_hang_not_login.getHoTen());
                khachhang.setSodienthoai(create_khach_hang_not_login.getSoDienThoai());
                khachhang.setTrangthai(0);
                userRepository_not_login.save(khachhang);

                // Tạo Địa Chỉ Cho Khách Hàng
                DiaChi diaChi = new DiaChi();

                diaChi.setIddiachi(UUID.randomUUID());
                diaChi.setDiachi(create_khach_hang_not_login.getDiaChi());
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

        HoaDon donHang = new HoaDon();

        donHang.setIddonhang(UUID.randomUUID());
        donHang.setMadonhang(maHd);
        donHang.setNgaytao(timestamp);
        donHang.setDiachi(create_khach_hang_not_login.getDiaChi() +" "+ create_khach_hang_not_login.getXa() +" "+create_khach_hang_not_login.getHuyen() +" "+create_khach_hang_not_login.getTinh());
        donHang.setSdtnguoinhan(create_khach_hang_not_login.getSoDienThoai());
        donHang.setTennguoinhan(create_khach_hang_not_login.getHoTen());
        donHang.setUsers(khachhang);
        donHang.setThanhtien(create_khach_hang_not_login.getTongTien());
        donHang.setTienkhachtra(create_khach_hang_not_login.getTienKhachTra());
//        donHang.setTienthua(create_khach_hang_not_login.getTienKhachTra() - create_khach_hang_not_login.getTongTien().doubleValue());

        donHang.setTrangthai(StatusOrderEnums.CHO_XAC_NHAN.getValue());
        donHangRepository_not_login.save(donHang);


        //Step3 : Xử lí hóa đơn chi tiết
        for (UUID idGioHangCT : create_khach_hang_not_login.getGioHangChiTietList()){
            // Tạo chi tiết hóa đơn cho mỗi sản phẩm trong giỏ hàng.

            Optional<GioHangChiTiet> gioHangChiTiet = gioHangChiTietRepository_not_login.findById(idGioHangCT);

            if (gioHangChiTiet.isPresent()){

                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setIdhoadonct(UUID.randomUUID());

                hdct.setDonhang(donHang);
                hdct.setCtsp(gioHangChiTiet.get().getCtsp());
                hdct.setSoluong(gioHangChiTiet.get().getSoluong());
                hdct.setDongia(gioHangChiTiet.get().getCtsp().getGiaban());

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

        return MessageThanhToanRepon_not_login.builder().message("Thanh Toán Thành Công").build();
    }
}
