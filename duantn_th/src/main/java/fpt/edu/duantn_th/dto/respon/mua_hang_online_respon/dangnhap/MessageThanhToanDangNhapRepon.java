package fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.dangnhap;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageThanhToanDangNhapRepon {
    String message;
    UUID idhoadon;
}
