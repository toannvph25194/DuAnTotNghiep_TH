package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "xuatxu")
public class XuatXu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idxuatxu;

    private String tenxuatxu;

    private String mota;

    private Long trangthai;

//  @JsonIgnore
    @OneToMany(mappedBy = "xuatxu")
    List<SanPham> sanpham;

}
