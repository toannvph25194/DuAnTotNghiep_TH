package fpt.edu.duantn_th.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "giohangchitiet")
public class GioHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idgiohangct;

    private Long soluong;
    private Double dongia;
    private Double dongiakhigiam;
    private Long trangthai;

    // Máp với ctsp N-1
    @ManyToOne
    @JoinColumn(name = "idctsp")
    ChiTietSanPham ctsp;

    // Máp với giỏ hàng N-1
    @ManyToOne
    @JoinColumn(name = "idgiohang")
    GioHang giohang;

}
