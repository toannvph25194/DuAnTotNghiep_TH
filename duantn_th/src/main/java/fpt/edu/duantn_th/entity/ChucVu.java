package fpt.edu.duantn_th.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import fpt.edu.duantn_th.enums.TypeAccountEnum;
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
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long idchucvu;

    @Column(name = "tenchucvu")
    @Enumerated(EnumType.STRING)
    private TypeAccountEnum tenchucvu;

    @Column(name = "trangthai")
    private Long trangthai;

    @OneToMany(mappedBy = "chucvu", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<User> users;

}
