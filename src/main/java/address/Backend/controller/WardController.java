package address.Backend.controller;

import address.Backend.entity.District;
import address.Backend.entity.Province;
import address.Backend.entity.Ward;
import address.Backend.form.DistrictFilterForm;
import address.Backend.form.WardFilterForm;
import address.Backend.service.ProvinceService;
import address.Backend.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class WardController {

    private final WardService wardService;


    @Autowired
    public WardController(WardService wardService) {
        this.wardService = wardService;
    }



    @GetMapping("/api/v1/wards")
    @ResponseStatus(HttpStatus.OK)
    public List<Ward> findAll(String form) {
        List<Ward> listWard = wardService.findAll(form);
        return listWard;
    }



    @GetMapping("/api/v1/wards/district/{districtId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ward> findByDistrictId(@PathVariable("districtId") Long districtId) {
        List<Ward> listWard = wardService.findByDistrictId(districtId);
        return listWard;
    }



    @GetMapping("/api/v1/wards/province/{provinceId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ward> findByProvinceId(@PathVariable("provinceId") Long provinceId) {
        List<Ward> listWard = wardService.findByProvinceId(provinceId);
        return listWard;
    }

    @GetMapping("/api/v1/wards/input")
    @ResponseStatus(HttpStatus.OK)
    public List<Ward> findByInput(String form) {
        return wardService.findByInput(form);
    }

}
