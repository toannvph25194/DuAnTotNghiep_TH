package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "giohang")
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "idgiohang")
    private UUID idgiohang;


    @Temporal(TemporalType.DATE)
    @Column(name = "ngaytao")
    Date ngaytao = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "ngaycapnhat")
    private Date ngaycapnhat ;

    @Column(name = "ghichu")
    private String ghichu;

    @Column(name = "trangthai")
    private Long trangthai;


    // Máp với giỏ hàng ct 1-N
    @OneToMany(mappedBy = "giohang" , fetch = FetchType.LAZY)
    @JsonManagedReference
    List<GioHangChiTiet> ghct;

    // Máp với users N-1
    @ManyToOne
    @JoinColumn(name = "idtk")
    @JsonBackReference
    User users;


}
