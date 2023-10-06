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
@Table(name = "chatlieu")
public class ChatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idchatlieu;

    private String tenchatlieu;
    private String mota;
    private Long trangthai;


    @OneToMany(mappedBy = "chatlieu")
    List<ChiTietSanPham> ctsp;
}
