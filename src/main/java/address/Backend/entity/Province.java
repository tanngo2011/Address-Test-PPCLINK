package address.Backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "province")
public class Province {

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "province_name")
    private String provinceName;

//    @OneToMany(mappedBy = "province")
//    private List<District> districts;
//
//
//    @OneToMany(mappedBy = "province")
//    private List<Ward> wards;
}
