package address.Backend.service;

import address.Backend.entity.District;
import address.Backend.entity.Ward;
import address.Backend.form.DistrictFilterForm;
import address.Backend.form.WardFilterForm;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WardService {

    public List<Ward> findByDistrictId(Long districtId);

    public List<Ward> findByProvinceId(Long provinceId);

    public List<Ward> findAll(WardFilterForm form);

    public List<Ward> findByInput(WardFilterForm form);
}
