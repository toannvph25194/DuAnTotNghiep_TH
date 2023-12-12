package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "taikhoan")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idtk;

    @Column(name = "hovaten")
    private String hovaten;

    @Column(name = "email")
    private String email;

    @Column(name = "taikhoan")
    private String taikhoan;

    @Column(name = "matkhau")
    private String matkhau;

    @Column(name = "image")
    private String image;

    @Column(name = "ngaysinh")
    private Date ngaysinh;

    @Column(name = "gioitinh")
    private Boolean gioitinh;

    @Column(name = "trangthai")
    private Integer trangthai;

    @Column(name = "sodienthoai")
    private String sodienthoai;

    // Máp với địa chỉ 1-N
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<DiaChi> diachi;

    // Máp với giỏ hàng 1-N
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<GioHang> giohang;

    // Máp với đơn hàng 1-N
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<HinhThucThanhToan> httt;

    // Máp với hình thức tt 1-N
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<DonHang> donhang;

    //Máp với refechtoken 1-N
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Refeshtoken> refeshtoken;

    //------------------------------
    // Máp với Chúc Vụ N-1
    @ManyToOne
    @JoinColumn(name = "idchucvu")
    @Enumerated(EnumType.STRING)
    @JsonBackReference
    ChucVu chucvu;


}

