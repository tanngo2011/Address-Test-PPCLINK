package address.Backend.service;

import address.Backend.dto.DistrictDto;
import address.Backend.entity.District;
import address.Backend.entity.Province;
import address.Backend.form.DistrictFilterForm;
import address.Backend.form.ProvinceFilterForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictService {


    public List<District> findAll(DistrictFilterForm form);

    public List<District> findByProvinceId(Long provinceId);


    public List<District> findByInput(DistrictFilterForm form);


    public List<District> findByWardId(Long wardId);

}
