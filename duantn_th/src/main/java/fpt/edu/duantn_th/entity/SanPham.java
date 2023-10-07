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
@Table(name = "sanpham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "idsp")
    private UUID idsp;

    @Column( name = "masp")
    private String masp;

    @Column( name = "tensp")
    private String tensp;

    @Column( name = "theloai")
    private Boolean theloai;

    @Column( name = "motasp")
    private String motasp;

    @Column( name = "trangthai")
    private Long trangthai;



    // Máp SPCT 1-N
    @OneToMany(mappedBy = "sanpham" ,fetch = FetchType.LAZY)
    @JsonManagedReference
    List<ChiTietSanPham> ctsp;


//--------------------------------------

    // Máp với thương hiệu N-1
    @ManyToOne
    @JoinColumn(name = "idthuonghieu")
    @JsonBackReference
    ThuongHieu thuonghieu;

    // Máp với xuất xứ N-1
    @ManyToOne
    @JoinColumn(name = "idxuatxu")
    @JsonBackReference
    XuatXu xuatxu;

    // Máp với danh muc N-1
    @ManyToOne
    @JoinColumn(name = "iddanhmuc")
    @JsonBackReference
    DanhMuc danhmuc;

}
