package address.Backend;

import address.Backend.entity.Ward;
import address.Backend.service.FileService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {



	@Autowired
	private FileService fileService;




	public static void main(String[] args) throws IOException, CsvValidationException {
		SpringApplication.run(BackendApplication.class, args);
	}



	@Bean
	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}



	@Override
	public void run(String... args) throws Exception {
//
//		String[] nextLine;
//
//		try (CSVReader reader = new CSVReader(new FileReader("district.csv"))) {
//
//			while ((nextLine = reader.readNext()) != null) {
//				// Truy cập đến từng giá trị trong dòng hiện tại
//				for (String value : nextLine) {
//					System.out.println(value);
//				}
//			}
//		}


		//Khi chương trình được khởi chạy: import file excel vào
		File file = new File("Addresses.xlsx");
		fileService.importFile(file);


	}
}
