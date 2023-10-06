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
@Table(name = "mausac")
public class MauSac {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idmausac;
    private String tenmausac;
    private Long trangthai;

    @OneToMany(mappedBy = "mausac")
    List<ChiTietSanPham> ctsp;

}
