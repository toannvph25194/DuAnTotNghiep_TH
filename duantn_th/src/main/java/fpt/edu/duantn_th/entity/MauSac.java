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
@Table(name = "mausac")
public class MauSac {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column( name = "idmausac")
    private UUID idmausac;

    @Column( name = "tenmausac")
    private String tenmausac;

    @Column( name = "trangthai")
    private Long trangthai;

    @OneToMany(mappedBy = "mausac",fetch = FetchType.LAZY)
    @JsonManagedReference
    List<ChiTietSanPham> ctsp;

}
