package address.Backend.controller;

import address.Backend.dto.DistrictDto;
import address.Backend.entity.District;
import address.Backend.entity.Province;
import address.Backend.form.DistrictFilterForm;
import address.Backend.service.DistrictService;
import address.Backend.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DistrictController {

    private final DistrictService districtService;


    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }


    @GetMapping("/api/v1/districts/province/{provinceId}")
    @ResponseStatus(HttpStatus.OK)
    public List<District> findByProvinceId(@PathVariable("provinceId") Long provinceId) {
        List<District> listDistrict = districtService.findByProvinceId(provinceId);
        return listDistrict;
    }



    @GetMapping("/api/v1/districts/ward/{wardId}")
    @ResponseStatus(HttpStatus.OK)
    public List<District> findByWardId(@PathVariable("wardId") Long wardId) {
        List<District> districts = districtService.findByWardId(wardId);
        return districts;
    }


    @GetMapping("/api/v1/districts")
    @ResponseStatus(HttpStatus.OK)
    public List<District> findAll(DistrictFilterForm form) {
        List<District> listDistrict = districtService.findAll(form);
        return listDistrict;
    }


    @GetMapping("/api/v1/districts/input")
    @ResponseStatus(HttpStatus.OK)
    public List<District> findByInput(DistrictFilterForm form) {
        return districtService.findByInput(form);
    }

}
