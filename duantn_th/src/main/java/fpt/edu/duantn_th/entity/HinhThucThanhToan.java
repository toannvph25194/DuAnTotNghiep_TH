package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "hinhthucthanhtoan")
public class HinhThucThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID idhtthanhtoan;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngaythanhtoan")
    Date ngaythanhtoan = new Date();

    @Column(name = "sotientra")
    private Double sotientra;

    @Column(name = "phuongthucthanhtoan")
    private Long phuongthucthanhtoan;

    @Column(name = "ghichu")
    private String ghichu;

    @Column(name = "trangthai")
    private Long trangthai;

    //Máp với đơn hàng N-1
    @ManyToOne
    @JoinColumn(name = "iddonhang")
    @JsonBackReference
    DonHang donhang;

    //Máp với users N-1
    @ManyToOne
    @JoinColumn(name = "idtk")
    @JsonBackReference
    User users;

}
