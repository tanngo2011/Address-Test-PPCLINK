package address.Backend;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) throws IOException, CsvValidationException {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		String[] nextLine;
//		try (CSVReader reader = new CSVReader(new FileReader("district.csv"))) {
//			while ((nextLine = reader.readNext()) != null) {
//				// Truy cập đến từng giá trị trong dòng hiện tại
//				for (String value : nextLine) {
//					System.out.println(value);
//				}
//			}
//		}
	}
}
