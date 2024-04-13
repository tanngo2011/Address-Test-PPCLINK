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


    //Thử làm theo cách bro Vanh hướng dẫn: tạo ra một trường tên viết tắt trong
    private Long id;

    private String districtName;

    private String unit;

    private String fullname;

    private Long provinceId;

}
