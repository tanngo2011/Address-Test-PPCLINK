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

    public Set<String> addProvince(List<Province> provinces) {
        Set<String> stringSet = new LinkedHashSet<>();
        if (!provinces.isEmpty()) {
            for (Province province : provinces) {
                if (province.getProvinceName() != null)
                    stringSet.add(province.getProvinceName());
            }
        }
        return stringSet;
    }



    public Set<String> addDistrict(List<District> districts) {
        Set<String> stringSet = new LinkedHashSet<>();
        String districtName = "";
        String wardName = "";
        if (!districts.isEmpty()) {
            for (District district : districts) {
                if (district.getDistrictName() != null) {

                    List<Province> provinces = provinceRepository.findByDistrictId(district.getId());
                    for (Province province : provinces) {
                        districtName = district.getDistrictName() + ", "
                                + province.getProvinceName();
                        stringSet.add(districtName);
                    }
                }
            }
        }

        return null;
    }


    public Set<String> addWard(List<Ward> wards) {
        Set<String> stringSet = new LinkedHashSet<>();
        String districtName = "";
        String wardName = "";
        String provinceName = "";
        if (!wards.isEmpty()) {
            for (Ward ward : wards) {
                if (ward.getWardName() != null) {

//                    stringSet.add(wardName);

                    List<Province> provinces = provinceRepository.findByWardId(ward.getId());
                    for (Province province : provinces) {
                        provinceName = province.getProvinceName();
                    }

                    List<District> districts = districtRepository.findByWardId(ward.getId());
                    for (District district : districts) {
                        districtName = district.getDistrictName();
                    }

                    wardName = ward.getUnit() + " " + ward.getWardName()
                            + ", " + districtName
                            + ", " + provinceName;
                    stringSet.add(wardName);
                }
            }
        }

        return stringSet;
    }




    @Override
    public Set<String> search(String form) {
        Set<String> stringSet = new LinkedHashSet<>();


        List<Province> provinces1 = provinceService.findAll(form);
        if (addProvince(provinces1) != null) {
            stringSet.addAll(addProvince(provinces1));
        }

        List<Province> provinces2 = provinceService.findByInput(form);
        if (addProvince(provinces2) != null) {
            stringSet.addAll(addProvince(provinces2));
        }



        List<District> districts1 = districtService.findAll(form);
        if (addDistrict(districts1) != null) {
            stringSet.addAll(addDistrict(districts1));
        }


        List<District> districts2 = districtService.findByInput(form);
        if (addDistrict(districts2) != null) {
            stringSet.addAll(addDistrict(districts2));
        }


        List<Ward> wards1 = wardService.findAll(form);
        if (addWard(wards1) != null) {
            stringSet.addAll(addWard(wards1));
        }


        List<Ward> wards2 = wardService.findByInput(form);
        if (addWard(wards2) != null) {
            stringSet.addAll(addWard(wards2));
        }



        return stringSet;
    }
}
