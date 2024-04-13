package address.Backend.dto;

import address.Backend.entity.District;
import address.Backend.entity.Province;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WardDto {

    private Long id;

    private String wardName;

    private String unit;

    private Long provinceId;

    private Long districtId;
}
