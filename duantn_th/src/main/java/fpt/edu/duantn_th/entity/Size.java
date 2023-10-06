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
@Table(name = "size")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idsize;

    private String tensize;
    private String mota;
    private Long trangthai;

    @OneToMany(mappedBy = "size")
    List<ChiTietSanPham> ctsp;

}
