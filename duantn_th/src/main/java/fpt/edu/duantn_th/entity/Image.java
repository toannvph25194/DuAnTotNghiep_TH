package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)


    @Column(name = "id")
    private UUID idimage;

    @Column(name = "tenimage")
    private String tenimage;

    @Column(name = "trangthai")
    private Long trangthai;

    @Column(name = "isdefault")
    private Boolean isdefault;

    @ManyToOne
    @JoinColumn(name = "idsp")
    @JsonBackReference
    SanPham sanpham;

}
