package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)

    @Column(name = "idtk")
    private UUID idtk;

    @Column(name = "ten")
    private String ten;

    @Column(name = "tendem")
    private String tendem;

    @Column(name = "ho")
    private String ho;

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
    private Long trangthai;



    // Máp với địa chỉ 1-N
    @OneToMany(mappedBy = "users" , fetch = FetchType.LAZY)
    @JsonManagedReference
    List<DiaChi> diachi;

    // Máp với giỏ hàng 1-N
    @OneToMany(mappedBy = "users" , fetch = FetchType.LAZY)
    @JsonManagedReference
    List<GioHang> giohang;

    // Máp với đơn hàng 1-N
    @OneToMany(mappedBy = "users" , fetch = FetchType.LAZY)
    @JsonManagedReference
    List<HinhThucThanhToan> httt;

    // Máp với hình thức tt 1-N
    @OneToMany(mappedBy = "users" , fetch = FetchType.LAZY)
    @JsonManagedReference
    List<DonHang> donhang;

    //Máp với refechtoken 1-N
    @OneToMany(mappedBy = "users" , fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Refeshtoken> refeshtoken;

//------------------------------
    // Máp với Chúc Vụ N-1
    @ManyToOne
    @JoinColumn( name = "idchucvu")
    @JsonBackReference
    ChucVu chucvu;


}
