package fpt.edu.duantn_th.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)

    private UUID idtk;
    private String ten;
    private String tendem;
    private String ho;
    private String email;
    private String taikhoan;
    private String matkhau;
    private String image;
    private Date ngaysinh;
    private Boolean gioitinh;
    private Long trangthai;


    // Máp với địa chỉ 1-N
    @OneToMany(mappedBy = "users")
    List<DiaChi> diachi;

    // Máp với giỏ hàng 1-N
    @OneToMany(mappedBy = "users")
    List<GioHang> giohang;

    // Máp với đơn hàng 1-N
    @OneToMany(mappedBy = "users")
    List<HinhThucThanhToan> httt;

    // Máp với hình thức tt 1-N
    @OneToMany(mappedBy = "users")
    List<DonHang> donhang;

//------------------------------
    // Máp với Chúc Vụ N-1
    @ManyToOne
    @JoinColumn( name = "idchucvu")
    ChucVu chucvu;


}
