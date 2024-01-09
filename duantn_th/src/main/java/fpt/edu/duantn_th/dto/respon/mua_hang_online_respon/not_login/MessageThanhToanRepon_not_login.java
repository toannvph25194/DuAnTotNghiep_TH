package fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.not_login;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageThanhToanRepon_not_login {
    private String message;
    private UUID idhoadon;
}
