package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "xuatxu")
public class XuatXu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID idxuatxu;

    @Column(name = "tenxuatxu")
    private String tenxuatxu;

    @Column(name = "mota")
    private String mota;

    @Column(name = "trangthai")
    private Long trangthai;

//  @JsonIgnore
    @OneToMany(mappedBy = "xuatxu" , fetch = FetchType.LAZY)
    @JsonManagedReference
    List<SanPham> sanpham;

}
