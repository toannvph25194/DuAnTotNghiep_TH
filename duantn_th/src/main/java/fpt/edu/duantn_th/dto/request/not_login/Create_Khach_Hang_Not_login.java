package fpt.edu.duantn_th.dto.request.not_login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Create_Khach_Hang_Not_login {

    private String hoTen;

    private String soDienThoai;

    private String email;

    private String diaChi;

    private String tinh;

    private String huyen;

    private String xa;

    private Double tongTien;

    private Double tienKhachTra;

    private Double tienThua;

//    private Integer phuongThuongThanhToan;

    private List<UUID> gioHangChiTietList;


}
