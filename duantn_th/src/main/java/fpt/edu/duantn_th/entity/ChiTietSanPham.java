package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "chitietsp")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID idctsp;

    @Column(name = "gianhap")
    private Double gianhap;

    @Column(name = "giaban")
    private Double giaban;

    @Column(name = "soluongton")
    private Long soluongton;

    @Column(name = "mota")
    private String mota;

    @Column(name = "trangthai")
    private Long trangthai;

    // Máp với giỏ hàng ct 1-N
    @OneToMany(mappedBy = "ctsp",fetch = FetchType.LAZY)
    @JsonManagedReference
    List<GioHangChiTiet> giohangct;

    // Máp với hóa đơn ct 1-N
    @OneToMany(mappedBy = "ctsp",fetch = FetchType.LAZY)
    @JsonManagedReference
    List<HoaDonChiTiet> hoadonct;


//------------------------------------


    // Máp với Size N-1
    @ManyToOne
    @JoinColumn(name = "idsize")
    @JsonBackReference
    Size size;

    // Máp với màu sắc N-1
    @ManyToOne
    @JoinColumn(name = "idmausac")
    @JsonBackReference
    MauSac mausac;

    // Máp với sản phẩm  N-1
    @ManyToOne
    @JoinColumn(name = "idsp")
    @JsonBackReference
    SanPham sanpham;

}
