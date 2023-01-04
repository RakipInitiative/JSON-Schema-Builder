package de.bund.bfr.kidaeditorbackend;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KidaEditorBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KidaEditorBackendApplication.class, args);
	}

	@Bean
	public OpenAPI openApiDef(
			@Value("${app.version:}") String appVersion, @Value("${server.servlet.context-path:}") String contextPath) {
		return new OpenAPI()
				.addServersItem(new Server().url(contextPath)
						.description("same system"))
				.info(new Info().title("Kida Backend")
						.description("This is the rest interface offered by the Kida Backend service to interact with a git repository.")
						.version(appVersion)
						.contact(new Contact().name("CGI")
								.email("peter.hoffmann@cgi.com")
								));
	}

}
