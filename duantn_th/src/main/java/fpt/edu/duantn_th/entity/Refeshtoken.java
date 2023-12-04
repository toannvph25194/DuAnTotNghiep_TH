package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "refeshtoken")
public class Refeshtoken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "thoigianhethan")
    private LocalDate thoigianhethan;

    @Column(name = "token")
    private String token;


    //Máp với users N-1
    @ManyToOne
    @JoinColumn(name = "idtk")
    @JsonBackReference
    User users;

}
