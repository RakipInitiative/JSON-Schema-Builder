package de.bund.bfr.kidaeditorbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KidaEditorBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KidaEditorBackendApplication.class, args);
	}

}
