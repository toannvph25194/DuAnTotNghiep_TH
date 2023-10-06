package fpt.edu.duantn_th.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idimage;
    private String tenimage;
    private Long trangthai;
    private Boolean isdefault;

    @ManyToOne
    @JoinColumn(name = "idctsp")
    ChiTietSanPham ctsp;

}
