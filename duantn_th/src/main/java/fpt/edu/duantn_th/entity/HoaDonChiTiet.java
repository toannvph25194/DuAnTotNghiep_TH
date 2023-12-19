package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "hoadonchitiet")
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID idhoadonct;

    @Column(name = "soluong")
    private Integer soluong;

    @Column(name = "dongia")
    private Double dongia;

    @Column(name = "dongiakhigiam")
    private Double dongiakhigiam;

    @Column(name = "trangthai")
    private Integer trangthai;

    //Máp với spct N-1
    @ManyToOne
    @JoinColumn(name = "idctsp")
    @JsonBackReference
    ChiTietSanPham ctsp;

    //Máp với đơn hàng N-1
    @ManyToOne
    @JoinColumn(name = "idhoadon")
    @JsonBackReference
    HoaDon hoadon;

}
