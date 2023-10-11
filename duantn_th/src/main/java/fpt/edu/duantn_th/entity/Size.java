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
@Table(name = "size")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID idsize;

    @Column(name = "tensize")
    private String tensize;

    @Column(name = "mota")
    private String mota;

    @Column(name = "trangthai")
    private Long trangthai;

    @OneToMany(mappedBy = "size" , fetch = FetchType.LAZY)
    @JsonManagedReference
    List<ChiTietSanPham> ctsp;

}
