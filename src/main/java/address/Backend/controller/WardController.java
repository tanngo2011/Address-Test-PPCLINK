package address.Backend.controller;

import address.Backend.entity.Province;
import address.Backend.entity.Ward;
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

    @GetMapping("/api/v1/wards/{districtId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ward> findByDistrictId(@PathVariable("districtId") Long districtId) {
        List<Ward> listWard = wardService.findByDistrictId(districtId);
        return listWard;
    }

}
