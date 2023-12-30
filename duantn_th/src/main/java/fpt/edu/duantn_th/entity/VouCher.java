package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "voucher")
public class VouCher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID idvoucher;

    @Column(name = "mavoucher")
    private String mavoucher;

    @Column(name = "tenvoucher")
    private String tenvoucher;

    @Column(name = "ngaytao")
    private Date ngaytao;

    @Column(name = "ngaybatdau")
    private Date ngaybatdau;

    @Column(name = "ngayketthuc")
    private Date ngayketthuc;

    @Column(name = "ngaycapnhat")
    private Date ngaycapnhat;

    @Column(name = "soluongma")
    private Integer soluongma;

    @Column(name = "soluongdung")
    private Integer soluongdung;

    @Column(name = "giatrigiam")
    private Integer giatrigiam;

    @Column(name = "giatritoithieuhoadon")
    private Integer giatritoithieuhoadon;

    @Column(name = "hinhthucgiam")
    private Integer hinhthucgiam;

    @Column(name = "trangthai")
    private Integer trangthai;


    // Máp với hoadon 1-N
    @OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<HoaDon> hoadon;


}
