package address.Backend.controller;

import address.Backend.entity.District;
import address.Backend.entity.Province;
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


    @GetMapping("/api/v1/districts/{provinceId}")
    @ResponseStatus(HttpStatus.OK)
    public List<District> findByProvinceId(@PathVariable("provinceId") Long provinceId) {
        List<District> listDistrict = districtService.findByProvinceId(provinceId);
        return listDistrict;
    }


}
