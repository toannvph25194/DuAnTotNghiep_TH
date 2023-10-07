package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "chucvu")
public class ChucVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idtk")
    private Long idtk;

    @Column(name = "tenchucvu")
    private String tenchucvu;

    @Column(name = "trangthai")
    private Long trangthai;

    @OneToMany(mappedBy = "chucvu", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<User> users;

}
