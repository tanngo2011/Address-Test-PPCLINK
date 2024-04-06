package address.Backend.service;

import address.Backend.entity.Ward;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WardService {

    public List<Ward> findByDistrictId(Long districtId);
}
