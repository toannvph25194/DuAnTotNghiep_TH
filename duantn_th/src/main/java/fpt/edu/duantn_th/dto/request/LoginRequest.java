package fpt.edu.duantn_th.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LoginRequest {

    @NotBlank(message = "Không được để trống username")
    private String taikhoan;

    @NotBlank(message = "Không được để trống password")
    private String matkhau;
}
