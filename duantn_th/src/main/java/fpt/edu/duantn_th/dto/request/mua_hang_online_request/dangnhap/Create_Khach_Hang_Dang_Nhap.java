package fpt.edu.duantn_th.dto.request.mua_hang_online_request.dangnhap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Create_Khach_Hang_Dang_Nhap {

    private String hovaten;

    private String sodienthoai;

    private String email;

    private String diachi;

    private String tinh;

    private String huyen;

    private String xa;

    private Double tongTien;

    private Double tienKhachTra;

    private Integer phuongThucThanhToan;

    private UUID idvoucher;

    private Double giatrigiam;

    private List<UUID> gioHangChiTietList;
}
