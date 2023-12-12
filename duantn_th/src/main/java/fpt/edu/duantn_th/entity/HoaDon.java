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
@Table(name = "hoadon")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)


    @Column(name = "id")
    private UUID iddonhang;

    @Column(name = "madonhang")
    private String madonhang;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngaytao")
    Date ngaytao = new Date();

    @Column(name = "ngaycapnhat")
    private Date ngaycapnhat;

    @Column(name = "ngaygiaohang")
    private Date ngaygiaohang;

    @Column(name = "ngaynhan")
    private Date ngaynhan;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngaythanhtoan")
    Date ngaythanhtoan = new Date();

    @Column(name = "tennguoinhan")
    private String tennguoinhan;

    @Column(name = "diachi")
    private String diachi;

    @Column(name = "sdtnguoinhan")
    private String sdtnguoinhan;

    @Column(name = "tennguoigiao")
    private String tennguoigiao;

    @Column(name = "sdtnguoigiao")
    private String sdtnguoigiao;

    @Column(name = "giatrigiam")
    private Double giatrigiam;

    @Column(name = "tiengiaohang")
    private Double tiengiaohang;

    @Column(name = "tienkhachtra")
    private Double tienkhachtra;

    @Column(name = "tienthua")
    private Double tienthua;

    @Column(name = "thanhtien")
    private Double thanhtien;

    @Column(name = "trangthai")
    private Integer trangthai;

    // Máp với hình thức thanh toán 1-N
    @OneToMany(mappedBy = "donhang", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<HinhThucThanhToan> httt;

    // Máp với Hóa đơn ct 1-N
    @OneToMany(mappedBy = "donhang",fetch = FetchType.LAZY)
    @JsonManagedReference
    List<HoaDonChiTiet> hoadonct;

//----------------------------
    // Máp với user N-1
    @ManyToOne
    @JoinColumn(name = "idtk")
    @JsonBackReference
    User users;


}
