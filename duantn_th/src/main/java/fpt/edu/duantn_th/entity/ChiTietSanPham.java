package fpt.edu.duantn_th.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chitietsp")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idctsp;

    private Double gianhap;
    private Double giaban;
    private Long baohanh;
    private Long soluongton;
    private String mota;
    private Long trangthai;
    private String qrcode;



    // Máp với Image 1-N
    @OneToMany(mappedBy = "ctsp")
    List<Image> image;

    // Máp với giỏ hàng ct 1-N
    @OneToMany(mappedBy = "ctsp")
    List<GioHangChiTiet> giohangct;


//------------------------------------


    // Máp với chất liệu N-1
    @ManyToOne
    @JoinColumn(name = "idchatlieu")
    ChatLieu chatlieu;

    // Máp với Size N-1
    @ManyToOne
    @JoinColumn(name = "idsize")
    Size size;

    // Máp với màu sắc N-1
    @ManyToOne
    @JoinColumn(name = "idmausac")
    MauSac mausac;

    // Máp với sản phẩm  N-1
    @ManyToOne
    @JoinColumn(name = "idsp")
    SanPham sanpham;

}
