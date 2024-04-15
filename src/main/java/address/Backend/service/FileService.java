package address.Backend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    void importFIle(MultipartFile file) throws IOException;
}
