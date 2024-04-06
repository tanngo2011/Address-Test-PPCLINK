package address.Backend.service;

import address.Backend.entity.Ward;
import address.Backend.repository.DistrictRepository;
import address.Backend.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService {


    private final WardRepository wardRepository;


    @Autowired
    public WardServiceImpl(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }


    public List<Ward> findByDistrictId(Long districtId) {
        List<Ward> listWard = wardRepository.findByDistrictId(districtId);
        return listWard;
    }
}
