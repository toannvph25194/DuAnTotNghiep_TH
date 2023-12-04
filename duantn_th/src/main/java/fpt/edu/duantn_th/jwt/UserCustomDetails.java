package fpt.edu.duantn_th.jwt;


import fpt.edu.duantn_th.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCustomDetails implements UserDetails{
    private User taiKhoan;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(taiKhoan.getChucvu().getTenchucvu().name()));

    }


    @Override// TODO Trả về mật khẩu được sử dụng để xác thực người dùng
    public String getPassword() {
        return taiKhoan.getMatkhau();
    }


    @Override// TODO Trả về tên tài khoản để xác thực người dùng
    public String getUsername() {
        return taiKhoan.getTaikhoan();
    }

    @Override// TODO Cho biết tài khoản người dùng đã hết hạn chưa
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override// TODO Cho biết người dùng bị khóa hay mở khóa.
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override// TODO Cho biết thông tin đăng nhập (mật khẩu) của người dùng đã hết hạn hay chưa.
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override// TODO Cho biết người dùng bật hay tắt
    public boolean isEnabled() {
        return true;
    }

}
