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
@Table(name = "donhang")
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID iddonhang;
    private String madonhang;

    @Temporal(TemporalType.DATE)
    @Column(name = "NgayTao")
    Date ngaytao = new Date();

    private Date ngaycapnhat;
    private Date ngaygiaohang;
    private Date ngaynhan;


    @Temporal(TemporalType.DATE)
    @Column(name = "NgayThanhToan")
    Date ngaythanhtoan = new Date();

    private String tennguoinhan;
    private String diachi;
    private String sdtnguoinhan;
    private String tennguoigiao;
    private String sdtnguoigiao;

    private Double giatrigiam;
    private Double tiengiaohang;
    private Double tienkhachtra;
    private Double tienthua;
    private Double thanhtien;

    private Long trangthai;
    private String qrcode;

    // Máp với hình thức thanh toán 1-N
    @OneToMany(mappedBy = "donhang")
    List<HinhThucThanhToan> httt;

//----------------------------
    // Máp với user N-1
    @ManyToOne
    @JoinColumn(name = "idtk")
    User users;


}
