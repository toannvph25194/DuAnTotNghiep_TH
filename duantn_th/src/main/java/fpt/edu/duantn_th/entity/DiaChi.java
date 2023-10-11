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
@Table(name = "diachi")
public class DiaChi {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID iddiachi;

    @Column(name = "diachi")
    private String diachi;

    @Column(name = "xa")
    private String xa;

    @Column(name = "huyen")
    private String huyen;

    @Column(name = "tinh")
    private String tinh;

    @Column(name = "quocgia")
    private String quocgia;

    @Column(name = "trangthai")
    private Long trangthai;

    @ManyToOne
    @JoinColumn(name = "idtk")
    @JsonBackReference
    User users;


}
