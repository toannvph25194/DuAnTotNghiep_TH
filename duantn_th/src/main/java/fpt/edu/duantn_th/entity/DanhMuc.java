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
@Table(name = "danhmuc")
public class DanhMuc {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID iddanhmuc;

    private String tendanhmuc;

    private String mota;

    private Long trangthai;

    @OneToMany(mappedBy = "danhmuc")
    List<SanPham> sanpham;
}
