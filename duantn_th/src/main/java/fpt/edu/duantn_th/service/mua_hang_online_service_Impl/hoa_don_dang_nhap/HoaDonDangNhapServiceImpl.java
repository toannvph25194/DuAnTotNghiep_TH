package fpt.edu.duantn_th.service.mua_hang_online_service_Impl.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.request.mua_hang_online_request.dangnhap.Create_Khach_Hang_Dang_Nhap;
import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.dangnhap.MessageThanhToanDangNhapRepon;
import fpt.edu.duantn_th.entity.*;
import fpt.edu.duantn_th.enums.StatusOrderEnums;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.HinhThucThanhToanRepository;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.VouCherRepository;
import fpt.edu.duantn_th.repository.mua_hang_online_repository.hoa_don_dang_nhap.*;
import fpt.edu.duantn_th.service.mua_hang_online_service.hoa_don_dang_nhap.HoaDonDangNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class HoaDonDangNhapServiceImpl implements HoaDonDangNhapService {


    @Autowired
    UserDangNhapRepository userDangNhapRepository;

    @Autowired
    HoaDonDangNhapRepository hoaDonDangNhapRepository;

    @Autowired
    GioHangCTDangNhapRepository gioHangCTDangNhapRepository;

    @Autowired
    HoaDonCTDangNhapRepository hoaDonCTDangNhapRepository;

    @Autowired
    GioHangDangNhapRepository gioHangDangNhapRepository;

    @Autowired
    HinhThucThanhToanRepository hinhThucThanhToanRepository;

    @Autowired
    VouCherRepository vouCherRepository;

    @Override
    public MessageThanhToanDangNhapRepon thanhToanDN(Create_Khach_Hang_Dang_Nhap khachHangDangNhap , Principal principal) {

            Optional<VouCher> vouCher = vouCherRepository.findById(khachHangDangNhap.getIdvoucher());
            // Step 1: Lấy thông tin người dùng đã đăng nhập
            String taikhoan = principal.getName();

            // Kiểm tra xem người dùng đã đăng nhập hay chưa
            if (taikhoan != null) {

                // Step 2: Lấy thông tin người dùng từ cơ sở dữ liệu (hoặc từ Principal)
                User khachHang = userDangNhapRepository.findByTaikhoan(taikhoan);
                System.out.println("Thông Tin Người Dùng :" + userDangNhapRepository.findByTaikhoan(principal.getName()));
                // Step 3: Thực hiện thanh toán sử dụng thông tin người dùng đã lấy được
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Random rand = new Random();
                int randomNumber = rand.nextInt(100000);
                String maHd = String.format("HD%03d", randomNumber);

                HoaDon hoadon = new HoaDon();
                hoadon.setIdhoadon(UUID.randomUUID());
                hoadon.setMadonhang(maHd);
                hoadon.setNgaytao(timestamp);
                hoadon.setDiachi(khachHangDangNhap.getDiachi() + " " + khachHangDangNhap.getXa() + " " + khachHangDangNhap.getHuyen() + " " + khachHangDangNhap.getTinh());
                hoadon.setSdtnguoinhan(khachHangDangNhap.getSodienthoai());
                hoadon.setTennguoinhan(khachHangDangNhap.getHovaten());
                hoadon.setUsers(khachHang);
                hoadon.setThanhtien(khachHangDangNhap.getTongTien());
                hoadon.setTienkhachtra(khachHangDangNhap.getTienKhachTra());
                hoadon.setGiatrigiam(khachHangDangNhap.getGiatrigiam());
                // Check Nếu IdVouCher Là Null thì Sẽ K Lưu
                if (vouCher.isPresent()) {
                    hoadon.setVoucher(vouCher.get());
                    vouCher.get().setSoluongdung(vouCher.get().getSoluongdung() + 1);

                    // Save Vào cơ sở dữ liệu
                    vouCherRepository.save(vouCher.get());
                }


                hoadon.setTrangthai(StatusOrderEnums.CHO_XAC_NHAN.getValue());
                hoaDonDangNhapRepository.save(hoadon);

                // Sử Lý Hình Thức Thanh Toán
                HinhThucThanhToan hinhthucTT = new HinhThucThanhToan();
                hinhthucTT.setIdhtthanhtoan(UUID.randomUUID());
                hinhthucTT.setHoadon(hoadon);
                hinhthucTT.setUsers(khachHang);
                hinhthucTT.setNgaythanhtoan(timestamp);
                hinhthucTT.setSotientra(khachHangDangNhap.getTongTien());
                hinhthucTT.setPhuongthucthanhtoan(khachHangDangNhap.getPhuongThucThanhToan());
                hinhthucTT.setGhichu("OK");
                hinhthucTT.setTrangthai(1);

                hinhThucThanhToanRepository.save(hinhthucTT);

                //Step3 : Xử lí hóa đơn chi tiết
                for (UUID idGioHangCT : khachHangDangNhap.getGioHangChiTietList()) {
                    // Tạo chi tiết hóa đơn cho mỗi sản phẩm trong giỏ hàng.

                    Optional<GioHangChiTiet> gioHangChiTiet = gioHangCTDangNhapRepository.findById(idGioHangCT);

                    if (gioHangChiTiet.isPresent()) {

                        HoaDonChiTiet hdct = new HoaDonChiTiet();
                        hdct.setIdhoadonct(UUID.randomUUID());

                        hdct.setHoadon(hoadon);
                        hdct.setCtsp(gioHangChiTiet.get().getCtsp());
                        hdct.setSoluong(gioHangChiTiet.get().getSoluong());
                        hdct.setDongia(gioHangChiTiet.get().getCtsp().getSanpham().getGiaban());

                        hdct.setTrangthai(1);

                        hoaDonCTDangNhapRepository.save(hdct);

                    } else {
                        System.out.println("Giỏ Hàng Chi Tiết K Tồn Tại");
                        return MessageThanhToanDangNhapRepon.builder().message("Thanh Toán Thất Bại !").build();
                    }

                }

                //Step 4 : Cập nhật trạng thái của giỏ hàng thành 2 sau khi thanh toán
                for (UUID idGioHangChiTiet : khachHangDangNhap.getGioHangChiTietList()) {

                    Optional<GioHangChiTiet> gioHangChiTiet = gioHangCTDangNhapRepository.findById(idGioHangChiTiet);

                    if (gioHangChiTiet.isPresent()) {
                        System.out.println(gioHangChiTiet.get().getGiohang().getTrangthai());
                        gioHangChiTiet.get().getGiohang().setTrangthai(2);
                        gioHangDangNhapRepository.save(gioHangChiTiet.get().getGiohang());
                    }

                }

                //Step 5 : Đặt số lượng tất cả các sản phẩm trong giỏ hàng về 0
                for (UUID idGioHangChiTiet : khachHangDangNhap.getGioHangChiTietList()) {

                    Optional<GioHangChiTiet> gioHangChiTiet = gioHangCTDangNhapRepository.findById(idGioHangChiTiet);

                    if (gioHangChiTiet.isPresent()) {
                        gioHangChiTiet.get().setSoluong(0);
                        gioHangCTDangNhapRepository.save(gioHangChiTiet.get());
                    }

                }
                return MessageThanhToanDangNhapRepon.builder().message("Thanh Toán Thành Công").build();
            }else {
                return MessageThanhToanDangNhapRepon.builder().message("Người Dùng Chưa Đăng Nhâp").build();
            }

    }
}
