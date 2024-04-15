package address.Backend.service;

import address.Backend.entity.Province;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    private  final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";


    @Override
    public void importFIle(MultipartFile file) throws IOException {
        // check xem file co phari xlsx

        //inputStream chỉ là 1 thuôc tính của file
        InputStream is = file.getInputStream();


        //file là chỉ chung tất cả các loại file
        //workbook là đại diện cho file excel - một thuộc tính của file
        Workbook workbook = new XSSFWorkbook(is);
        //sheet
        Sheet sheet1 = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet1.iterator();

        List<Province> provinces = new ArrayList<>();

        int rowIndex = 0;
        while (rows.hasNext()) {
            Row row = rows.next();
            if (rowIndex==0){
                rowIndex++;
                continue;
            }
            if (row.getCell(0).getNumericCellValue() ==0 ){
                break;
            }

            Iterator<Cell> cells = row.iterator();
            Province province = new Province();
            int cellIndex = 0;
            while (cells.hasNext()) {
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
            provinces.add(province);
        }
        //saveAll(list)
        System.out.println();

    }
}
