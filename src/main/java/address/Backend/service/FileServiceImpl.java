package address.Backend.service;

import address.Backend.entity.District;
import address.Backend.entity.Province;
import address.Backend.entity.Ward;
import address.Backend.repository.DistrictRepository;
import address.Backend.repository.ProvinceRepository;
import address.Backend.repository.WardRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{


    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;
    private final WardRepository wardRepository;



    @Autowired
    public FileServiceImpl(
            DistrictRepository districtRepository,
            ProvinceRepository provinceRepository,
            WardRepository wardRepository
    ) {
        this.districtRepository = districtRepository;
        this.provinceRepository = provinceRepository;
        this.wardRepository = wardRepository;

    }



    //method importFileTest1() được viết theo hướng dẫn trong link sau: https://gist.github.com/zubayer-ahamed/ed14b5dbec00700e1ba0c4cfc3b016a0
    //Tham số có kiểu dữ liệu MultipartFile trong method này được truyền vào qua Request Param.
    @Override
    public void importFileTest1(MultipartFile file) throws IOException {


//        //inputStream chỉ là 1 thuộc tính của file
//        InputStream is = file.getInputStream();
//
//
//        //file là chỉ chung tất cả các loại file
//        //workbook là đại diện cho file excel - một thuộc tính của file
//        Workbook workbook = new XSSFWorkbook(is);


//        //sheet là object tương ứng với từng sheet trong file excel:
//        Sheet sheet1 = workbook.getSheetAt(0);


//        //Row đại diên cho các hàng trong bảng excel:
//        Iterator<Row> rows = sheet1.iterator();
//
//        List<Province> provinces = new ArrayList<>();
//
//        int rowIndex = 0;
//        while (rows.hasNext()) {
//            Row row = rows.next();

//            //Câu lệnh dùng để bỏ qua hàng đầu tiên trong bảng tính excel (vì hàng đầu tiên là
//            //hàng tiêu đề)
//            if (rowIndex==0){
//                rowIndex++;
//                continue;
//            }
//            if (row.getCell(0).getNumericCellValue() ==0 ){
//                break;
//            }
//
//            Iterator<Cell> cells = row.iterator();
//            Province province = new Province();
//            int cellIndex = 0;
//            while (cells.hasNext()) {
//                Cell cell = cells.next();
//                switch (cellIndex) {
//                    case 0:
//                        province.setId((long) cell.getNumericCellValue());
//                        break;
//                    case 1:
//                        province.setProvinceName(cell.getStringCellValue());
//                        break;
//                    default:
//                        break;
//                }
//                cellIndex++;
//            }
//            provinces.add(province);
//        }
//        //saveAll(list)
//        System.out.println();
    }




    @Override
    public void importProvince(Workbook workbook) {

//        List<Province> provinces = new ArrayList<>();

        //sheet là object tương ứng với từng sheet trong file excel:
        Sheet sheet1 = workbook.getSheetAt(0);

        //Row đại diện cho các hàng trong bảng excel.
        //Ta biến các row thành iterator (Iterator là một interface trong Java được sử
        //dụng để duyệt qua các phần tử trong một tập hợp (collection) - theo Gemini).
        Iterator<Row> rows = sheet1.iterator();

        //Khai báo một biến để làm index cho từng row
        int rowIndex = 0;

        while (rows.hasNext()) {

            //lấy ra hàng hiện tại:
            Row row = rows.next();

            //Câu lệnh dùng để bỏ qua hàng đầu tiên trong bảng tính excel (vì hàng đầu tiên là
            //hàng tiêu đề)
            if (rowIndex==0){
                rowIndex++;
                continue;
            }

            //Câu lệnh dùng để dừng quá trình duyệt qua các hàng trong bảng excel khi danh sách
            //các tỉnh kết thúc
            if (row.getCell(0).getNumericCellValue() ==0 ){
                break;
            }

            //một row (từng hàng lẻ) bao gồm các cell --> biến row thành iterator để lấy ra các
            //cell
            Iterator<Cell> cells = row.iterator();
            Province province = new Province();

            //Khai báo một biến để làm index cho từng cell
            int cellIndex = 0;

            while (cells.hasNext()) {

                //lấy ra cell hiện tại:
                Cell cell = cells.next();

                switch (cellIndex) {
                    case 0:
                        province.setId((long) cell.getNumericCellValue());
                        break;
                    case 1:
                        province.setProvinceName(cell.getStringCellValue());
                        break;
                    default:
                        break;
                }
                cellIndex++;
            }
            provinceRepository.save(province);
//            provinces.add(province);
        }

//        System.out.println();
    };


    @Override
    public void importDistrict(Workbook workbook) {

//        List<District> districts = new ArrayList<>();


        //sheet là object tương ứng với từng sheet trong file excel:
        Sheet sheet1 = workbook.getSheetAt(1);

        //Row đại diện cho các hàng trong bảng excel.
        //Ta biến các row thành iterator (Iterator là một interface trong Java được sử
        //dụng để duyệt qua các phần tử trong một tập hợp (collection) - theo Gemini).
        Iterator<Row> rows = sheet1.iterator();

        //Khai báo một biến để làm index cho từng row
        int rowIndex = 0;
        while (rows.hasNext()) {

            //lấy ra hàng hiện tại:
            Row row = rows.next();

            //Câu lệnh dùng để bỏ qua hàng đầu tiên trong bảng tính excel (vì hàng đầu tiên là
            //hàng tiêu đề)
            if (rowIndex==0){
                rowIndex++;
                continue;
            }

            //Câu lệnh dùng để dừng quá trình duyệt qua các hàng trong bảng excel khi danh sách
            //các quận kết thúc
            if (row.getCell(0).getNumericCellValue() ==0 ){
                break;
            }


            //một row (từng hàng lẻ) bao gồm các cell --> biến row thành iterator để lấy ra các
            //cell
            Iterator<Cell> cells = row.iterator();
            District district = new District();

            //Khai báo một biến để làm index cho từng cell
            int cellIndex = 0;

            while (cells.hasNext()) {

                //lấy ra cell hiện tại:
                Cell cell = cells.next();

                switch (cellIndex) {
                    case 0:
                        district.setId((long )cell.getNumericCellValue());
                        break;
                    case 1:
                        district.setProvince(provinceRepository.findById((long) cell.getNumericCellValue()).get());
                        break;
                    case 2:
                        district.setUnit(cell.getStringCellValue());
                        break;
                    case 3:
                        district.setDistrictName(cell.getStringCellValue());
                        break;
                    case 4:
                        district.setFullname(cell.getStringCellValue());
                        break;
                    default:
                        break;
                }
                cellIndex++;
            }
            districtRepository.save(district);
//            System.out.println(district);
//            districts.add(district);
        }

//        System.out.println();
    };


    @Override
    public void importWard(Workbook workbook) {

//        List<District> districts = new ArrayList<>();


        //sheet là object tương ứng với từng sheet trong file excel:
        Sheet sheet1 = workbook.getSheetAt(2);

        //Row đại diện cho các hàng trong bảng excel.
        //Ta biến các row thành iterator (Iterator là một interface trong Java được sử
        //dụng để duyệt qua các phần tử trong một tập hợp (collection) - theo Gemini).
        Iterator<Row> rows = sheet1.iterator();

        //Khai báo một biến để làm index cho từng row
        int rowIndex = 0;

        while (rows.hasNext()) {

            //lấy ra hàng hiện tại:
            Row row = rows.next();

            //Câu lệnh dùng để bỏ qua hàng đầu tiên trong bảng tính excel (vì hàng đầu tiên là
            //hàng tiêu đề)
            if (rowIndex==0){
                rowIndex++;
                continue;
            }

            //Câu lệnh dùng để dừng quá trình duyệt qua các hàng trong bảng excel khi danh sách
            //các quận kết thúc
            if (row.getCell(0).getNumericCellValue() == 0 ){
                break;
            }


            //một row (từng hàng lẻ) bao gồm các cell --> biến row thành iterator để lấy ra các
            //cell
            Iterator<Cell> cells = row.iterator();
            Ward ward = new Ward();

            //Khai báo một biến để làm index cho từng cell
            int cellIndex = 0;

            while (cells.hasNext()) {

                //lấy ra cell hiện tại:
                Cell cell = cells.next();

                switch (cellIndex) {
                    case 0:
                        ward.setId((long )cell.getNumericCellValue());
                        break;
                    case 1:
                        ward.setProvince(provinceRepository.findById((long) cell.getNumericCellValue()).get());
                        break;
                    case 2:
                        ward.setDistrict(districtRepository.findById((long) cell.getNumericCellValue()).get());
                        break;
                    case 3:
                        ward.setUnit(cell.getStringCellValue());
                        break;
                    case 4:
                        if (cell.getCellType() == CellType.STRING) {
                            ward.setWardName(cell.getStringCellValue());
                            break;
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            ward.setWardName(String.valueOf((long) cell.getNumericCellValue()));
                            break;
                        }

                    default:
                        break;
                }
                cellIndex++;
            }
            wardRepository.save(ward);
//            System.out.println(district);
//            districts.add(district);
        }

//        System.out.println();
    };


    @Override
    public void importFile(File file) throws IOException {

        Workbook workbook = null;
        try {

            //file là chỉ chung tất cả các loại file
            //workbook là đại diện cho file excel - một thuộc tính của file
            workbook = WorkbookFactory.create(file);


            importProvince(workbook);

            importDistrict(workbook);

            importWard(workbook);



            //inputStream chỉ là 1 thuôc tính của file
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }

    }





}
