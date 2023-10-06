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
@Table(name = "giohang")
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID giohang;


    @Temporal(TemporalType.DATE)
    @Column(name = "NgayTao")
    Date ngaytao = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "NgayCapNhat")
    Date ngaycapnhat = new Date();

    private String ghichu;
    private Long trangthai;


    // Máp với giỏ hàng ct 1-N
    @OneToMany(mappedBy = "giohang")
    List<GioHangChiTiet> ghct;

    // Máp với users N-1
    @ManyToOne
    @JoinColumn(name = "idtk")
    User users;


}
