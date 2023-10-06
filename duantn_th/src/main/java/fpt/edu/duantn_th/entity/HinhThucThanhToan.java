package fpt.edu.duantn_th.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hinhthucthanhtoan")
public class HinhThucThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idhtthanhtoan;

    @Temporal(TemporalType.DATE)
    @Column(name = "NgayThanhToan")
    Date ngaythanhtoan = new Date();

    private Double tongtien;
    private Long phuongthucthanhtoan;
    private String ghichu;
    private Long trangthai;

    //Máp với đơn hàng N-1
    @ManyToOne
    @JoinColumn(name = "iddonhang")
    DonHang donhang;

    //Máp với users N-1
    @ManyToOne
    @JoinColumn(name = "idtk")
    User users;

}
