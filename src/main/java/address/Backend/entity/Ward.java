package address.Backend.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "ward")
public class Ward {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ward_name")
    private String wardName;

    @Column(name = "unit")
    private String unit;

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;

}
