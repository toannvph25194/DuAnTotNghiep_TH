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
@Table(name = "giohangchitiet")
public class GioHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID idgiohangct;

    @Column(name = "soluong")
    private Long soluong;

    @Column(name = "dongia")
    private Double dongia;

    @Column(name = "dongiakhigiam")
    private Double dongiakhigiam;

    @Column(name = "trangthai")
    private Long trangthai;

    // Máp với ctsp N-1
    @ManyToOne
    @JoinColumn(name = "idctsp")
    @JsonBackReference
    ChiTietSanPham ctsp;

    // Máp với giỏ hàng N-1
    @ManyToOne
    @JoinColumn(name = "idgiohang")
    @JsonBackReference
    GioHang giohang;

}
