package address.Backend.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileService {

    void importFileTest1(MultipartFile file) throws IOException;

    public void importProvince(Workbook workbook);

    public void importDistrict(Workbook workbook);

    public void importWard(Workbook workbook);

    public void importFile(File file) throws IOException;
}
