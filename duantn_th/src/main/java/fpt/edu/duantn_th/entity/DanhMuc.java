package fpt.edu.duantn_th.entity;


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
@Table(name = "danhmuc")
public class DanhMuc {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID iddanhmuc;

    @Column(name = "tendanhmuc")
    private String tendanhmuc;

    @Column(name = "mota")
    private String mota;

    @Column(name = "trangthai")
    private Long trangthai;

    @OneToMany(mappedBy = "danhmuc", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<SanPham> sanpham;
}
