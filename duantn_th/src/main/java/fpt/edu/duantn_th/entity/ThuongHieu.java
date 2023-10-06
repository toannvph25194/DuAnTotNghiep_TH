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
@Table(name = "thuonghieu")
public class ThuongHieu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idthuonghieu;

    private String tenthuonghieu;

    private String mota;

    private Long trangthai;

    @OneToMany(mappedBy = "thuonghieu")
    List<SanPham> sanpham;
}
