package address.Backend.service;

import address.Backend.entity.District;
import address.Backend.entity.Province;
import address.Backend.entity.Ward;
import address.Backend.repository.DistrictRepository;
import address.Backend.repository.ProvinceRepository;
import address.Backend.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class SearchServiceImpl implements SearchService {

    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;
    private final WardRepository wardRepository;

    private final ProvinceService provinceService;

    private final DistrictService districtService;

    private final WardService wardService;



    @Autowired
    public SearchServiceImpl(
            DistrictRepository districtRepository,
            ProvinceRepository provinceRepository,
            WardRepository wardRepository,
            ProvinceService provinceService,
            DistrictService districtService,
            WardService wardService
    ) {
        this.districtRepository = districtRepository;
        this.provinceRepository = provinceRepository;
        this.wardRepository = wardRepository;
        this.provinceService = provinceService;
        this.wardService = wardService;
        this.districtService = districtService;

    }



    @Override
    public Set<String> search(String form) {
        Set<String> stringSet = new LinkedHashSet<>();

        List<Province> provinces1 = provinceService.findAll(form);
        if (!provinces1.isEmpty()) {
            for (Province province : provinces1) {
                if (province.getProvinceName() != null)
                    stringSet.add(province.getProvinceName());
            }
        }

        List<Province> provinces2 = provinceService.findByInput(form);
        if (!provinces2.isEmpty()) {
            for (Province province : provinces2) {
                if (province.getProvinceName() != null)
                    stringSet.add(province.getProvinceName());
            }
        }

        List<District> districts1 = districtService.findAll(form);
        if (!districts1.isEmpty()) {
            for (District district : districts1) {
                if (district.getFullname() != null)
                    stringSet.add(district.getFullname());
            }
        }

        List<District> districts2 = districtService.findByInput(form);
        if (!districts2.isEmpty()) {
            for (District district : districts2) {
                if (district.getFullname() != null)
                    stringSet.add(district.getFullname());
            }
        }

        String wardName = "";
        List<Ward> wards1 = wardService.findAll(form);
        if (!wards1.isEmpty()) {
            for (Ward ward : wards1) {
                if (ward.getWardName() != null)
                    wardName = ward.getUnit() + " " + ward.getWardName();
                    stringSet.add(wardName);
            }
        }


        List<Ward> wards2 = wardService.findByInput(form);
        if (!wards2.isEmpty()) {
            for (Ward ward : wards2) {
                if (ward.getWardName() != null)
                    wardName = ward.getUnit() + " " + ward.getWardName();
                    stringSet.add(wardName);
            }
        }


        return stringSet;
    }
}
