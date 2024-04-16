package address.Backend.service;

import address.Backend.dto.DistrictDto;
import address.Backend.entity.District;
import address.Backend.entity.Province;
import address.Backend.form.DistrictFilterForm;
import address.Backend.repository.DistrictRepository;
import address.Backend.repository.ProvinceRepository;
import address.Backend.specification.DistrictSpecification;
import address.Backend.specification.ProvinceSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictServiceImpl implements DistrictService {


    private final DistrictRepository districtRepository;

    private ModelMapper modelMapper;


    @Autowired
    public DistrictServiceImpl(
            DistrictRepository districtRepository,
            ModelMapper modelMapper
    ) {
        this.districtRepository = districtRepository;
        this.modelMapper = modelMapper;
    }




    @Override
    public List<District> findAll(String form) {
        Specification<District> spec = DistrictSpecification.buildSpec(form);
        return districtRepository.findAll(spec);
    }



    @Override
    public List<District> findByProvinceId(Long provinceId) {

        List<District> listDistrict = districtRepository.findByProvinceId(provinceId);
        return listDistrict;
    }





    @Override
    public List<District> findByInput(String form) {

        //Khai báo một list các Province để trả về cho người dùng
        List<District> districtListOutput = new ArrayList<>();

        //Lấy danh sách các Province trong database
        List<District> districtList = districtRepository.findAll();

        //
        List<Character> listChar = new ArrayList<>();



        //xử lý danh sách Province mới lấy được từ database:
        //Lặp qua từng Province trong list Province:
        for (District district : districtList) {
            //Lấy ra name của Province đó:
            String dataName = district.getFullname().toLowerCase();

            //tách name ra thành words:
            String[] dataWord = dataName.split(" ");
            for (int i = 0; i < dataWord.length; i++) {
                String s = dataWord[i];

                //Lấy ra chữ cái đầu tiên của word trong tên Province và cho vào trong listChar:
                listChar.add(s.charAt(0));

            }

            String string = "";

            //lặp các ký tự trong listChar để tạo thành một string
            for (int i = 0; i < listChar.size(); i++) {
//                string = string + listChar[i];
                string = string.concat(listChar.get(i).toString());

            }

            //so sánh string vừa tạo (từ tên Province): nếu string vừa tạo có chứa provinceInput
            //mà người dùng nhập vào, thì thêm Province mà string đó được tạo từ vào trong List
            //provinceListOutPut
            if (string.contains(form.toLowerCase())) {
                districtListOutput.add(district);
            }

            System.out.println(string);

            //Phải clear listChar khi bắt đầu vòng lặp tiếp theo.
            listChar.clear();

        }


        return districtListOutput;
    }


    @Override
    public List<District> findByWardId(Long wardId) {
        return districtRepository.findByWardId(wardId);
    }
}
