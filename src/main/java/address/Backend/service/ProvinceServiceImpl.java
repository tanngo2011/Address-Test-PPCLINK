package address.Backend.service;

import address.Backend.entity.Province;
import address.Backend.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {


    private final ProvinceRepository provinceRepository;


    @Autowired
    public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }



    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
}
