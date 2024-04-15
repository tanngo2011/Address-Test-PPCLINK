package address.Backend.controller;

import address.Backend.entity.District;
import address.Backend.form.DistrictFilterForm;
import address.Backend.service.FileService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/api/v1/import")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAll(@RequestParam MultipartFile file) throws IOException {
        fileService.importFIle(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
