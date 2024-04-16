package address.Backend.controller;

import address.Backend.entity.Province;
import address.Backend.form.ProvinceFilterForm;
import address.Backend.repository.ProvinceRepository;
import address.Backend.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<Province> findAll(String form) {
        List<Province> listProvince = provinceService.findAll(form);
        return listProvince;
    }



    @GetMapping("/api/v1/provinces/input")
    @ResponseStatus(HttpStatus.OK)
    public List<Province> findByInput(String form) {
        List<Province> listProvince = provinceService.findByInput(form);
        return listProvince;
    }


    @GetMapping("/api/v1/provinces/ward/{wardId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Province> findByWardId(@PathVariable("wardId") Long wardId) {
        List<Province> provinces = provinceService.findByWardId(wardId);
        return provinces;
    }


    @GetMapping("/api/v1/provinces/district/{districtId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Province> findByDistrictId(@PathVariable("districtId") Long districtId) {
        List<Province> provinces = provinceService.findByDistrictId(districtId);
        return provinces;
    }

}
