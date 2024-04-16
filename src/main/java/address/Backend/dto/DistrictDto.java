package address.Backend.dto;

import address.Backend.entity.Province;
import address.Backend.entity.Ward;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistrictDto {

    private String districtName;


}
