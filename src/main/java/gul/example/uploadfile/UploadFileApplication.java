package gul.example.uploadfile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import gul.example.uploadfile.storage.StorageProperties;
import gul.example.uploadfile.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadFileApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService)
	{
		return (args) ->{
			storageService.deleteAll();
			storageService.init();
		};
	}

}
