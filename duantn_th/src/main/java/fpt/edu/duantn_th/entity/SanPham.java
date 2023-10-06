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
@Table(name = "sanpham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "IdSP")
    private UUID idsp;

//    @Column(name = "IdDanhMuc")
//    private UUID iddanhmuc;
//    @Column(name = "IdThuongHieu")
//    private UUID idthuonghieu;
//    @Column(name = "IdXuatXu")
//    private UUID idxuatxu;

    private String masp;
    private String tensp;
    private Boolean theloai;
    private String motasp;
    private Long trangthai;



    // Máp SPCT 1-N
    @OneToMany(mappedBy = "sanpham")
    List<ChiTietSanPham> ctsp;


//--------------------------------------

    // Máp với thương hiệu N-1
    @ManyToOne
    @JoinColumn(name = "idthuonghieu")
    ThuongHieu thuonghieu;

    // Máp với xuất xứ N-1
    @ManyToOne
    @JoinColumn(name = "idxuatxu")
    XuatXu xuatxu;

    // Máp với danh muc N-1
    @ManyToOne
    @JoinColumn(name = "iddanhmuc")
    DanhMuc danhmuc;

}
