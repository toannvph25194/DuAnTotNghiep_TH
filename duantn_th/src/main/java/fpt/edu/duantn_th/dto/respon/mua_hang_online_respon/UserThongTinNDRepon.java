package fpt.edu.duantn_th.dto.respon.mua_hang_online_respon;

import lombok.Data;

import java.util.Date;

@Data
public class UserThongTinNDRepon {

    private String taikhoan;
    private String hovaten;
    private String sodienthoai;
    private String email;
    private Date ngaysinh;
    private Boolean gioitinh;

}
