package address.Backend.service;

import address.Backend.entity.District;
import address.Backend.entity.Province;
import address.Backend.entity.Ward;
import address.Backend.form.WardFilterForm;
import address.Backend.repository.DistrictRepository;
import address.Backend.repository.WardRepository;
import address.Backend.specification.DistrictSpecification;
import address.Backend.specification.WardSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WardServiceImpl implements WardService {


    private final WardRepository wardRepository;


    @Autowired
    public WardServiceImpl(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }


    public List<Ward> findByDistrictId(Long districtId) {
        List<Ward> listWard = wardRepository.findByDistrictId(districtId);
        return listWard;
    }

    @Override
    public List<Ward> findByProvinceId(Long provinceId) {
        return wardRepository.findByProvinceId(provinceId);
    }

    @Override
    public List<Ward> findAll(WardFilterForm form) {
        Specification<Ward> spec = WardSpecification.buildSpec(form);
        return wardRepository.findAll(spec);
    }


    @Override
    public List<Ward> findByInput(WardFilterForm form) {
        //Khai báo một list các Province để trả về cho người dùng
        List<Ward> wardListOutput = new ArrayList<>();

        //Lấy danh sách các Province trong database
        List<Ward> wardList = wardRepository.findAll();

        //
        List<Character> listChar = new ArrayList<>();



        //xử lý danh sách Province mới lấy được từ database:
        //Lặp qua từng Province trong list Province:
        for (Ward ward : wardList) {
            //Lấy ra name của Province đó:
            String dataName = ward.getWardName().toLowerCase();

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
            if (string.contains(form.getWardInput().toLowerCase())) {
                wardListOutput.add(ward);
            }

            System.out.println(string);

            //Phải clear listChar khi bắt đầu vòng lặp tiếp theo.
            listChar.clear();

        }


        return wardListOutput;
    }
}
