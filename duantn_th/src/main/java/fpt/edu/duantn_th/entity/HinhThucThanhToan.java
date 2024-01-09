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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngaythanhtoan")
    private Date ngaythanhtoan;

    @Column(name = "sotientra")
    private Double sotientra;

    @Column(name = "phuongthucthanhtoan")
    private Integer phuongthucthanhtoan;

    @Column(name = "ghichu")
    private String ghichu;

    @Column(name = "trangthai")
    private Integer trangthai;

    @Column(name = "magiaodich")
    private String magiaodich;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngaycapnhat")
    private Date ngaycapnhat;

    //Máp với đơn hàng N-1
    @ManyToOne
    @JoinColumn(name = "idhoadon")
    @JsonBackReference
    HoaDon hoadon;

    //Máp với users N-1
    @ManyToOne
    @JoinColumn(name = "idtk")
    @JsonBackReference
    User users;

}
