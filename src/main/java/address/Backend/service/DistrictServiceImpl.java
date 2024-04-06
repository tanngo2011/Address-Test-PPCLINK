package address.Backend.service;

import address.Backend.entity.District;
import address.Backend.repository.DistrictRepository;
import address.Backend.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {


    private final DistrictRepository districtRepository;


    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }


    @Override
    public List<District> findByProvinceId(Long provinceId) {

        List<District> listDistrict = districtRepository.findByProvinceId(provinceId);
        return listDistrict;
    }
}
