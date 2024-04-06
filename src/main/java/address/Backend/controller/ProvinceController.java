package address.Backend.controller;

import address.Backend.entity.Province;
import address.Backend.repository.ProvinceRepository;
import address.Backend.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
public class ProvinceController {

    private final ProvinceService provinceService;


    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }


    @GetMapping("/api/v1/provinces")
    @ResponseStatus(HttpStatus.OK)
    public List<Province> findAll() {
        List<Province> listProvince = provinceService.findAll();
        return listProvince;
    }
}
