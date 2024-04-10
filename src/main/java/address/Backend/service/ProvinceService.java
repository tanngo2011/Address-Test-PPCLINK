package address.Backend.service;

import address.Backend.entity.Province;
import address.Backend.form.ProvinceFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvinceService {


    public List<Province> findAll(ProvinceFilterForm form);


    public List<Province> findByInput(ProvinceFilterForm form);



}
