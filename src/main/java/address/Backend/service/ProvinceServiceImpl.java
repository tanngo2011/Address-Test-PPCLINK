package address.Backend.service;

import address.Backend.entity.Province;
import address.Backend.form.ProvinceFilterForm;
import address.Backend.repository.DistrictRepository;
import address.Backend.repository.ProvinceRepository;
import address.Backend.specification.ProvinceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {


    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;


    @Autowired
    public ProvinceServiceImpl(ProvinceRepository provinceRepository,
                               DistrictRepository districtRepository) {
        this.provinceRepository = provinceRepository;
        this.districtRepository = districtRepository;
    }



    @Override
    public List<Province> findAll(ProvinceFilterForm form) {
        Specification<Province> spec = ProvinceSpecification.buildSpec(form); //--> buildSpec là Method static nên có thể được gọi trực tiếp từ Class
//        Specification.where(spec);
        return provinceRepository.findAll(spec);
    }







    @Override
    public List<Province> findByInput(ProvinceFilterForm form) {

        //Khai báo một list các Province để trả về cho người dùng
        List<Province> provinceListOutput = new ArrayList<>();

        //Lấy danh sách các Province trong database
        List<Province> provinceList = provinceRepository.findAll();

        //
        List<Character> listChar = new ArrayList<>();



        //xử lý danh sách Province mới lấy được từ database:
        //Lặp qua từng Province trong list Province:
        for (Province province : provinceList) {
            //Lấy ra name của Province đó:
            String dataName = province.getProvinceName().toLowerCase();

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
            if (string.contains(form.getProvinceInput().toLowerCase())) {
                provinceListOutput.add(province);
            }

            System.out.println(string);

            //Phải clear listChar khi bắt đầu vòng lặp tiếp theo.
            listChar.clear();

        }


        return provinceListOutput;
    }

}
