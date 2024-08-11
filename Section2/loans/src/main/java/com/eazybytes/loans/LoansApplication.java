package com.eazybytes.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API",
				description = "EazyBank Loans microservice REST API documentation",
				version = "v1",
				contact = @Contact(
						name = "Anushka Suryawanshi",
						email = "anushkasuryawanshi27@gmail.com",
						url = "add url"
				),
				license = @License(
						name = "Apache 2.0",
						url = "add url"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank loans microservice REST API documentation",
				url = "https://www.eazybytes.com/swagger-ui.html"
		)
)
public class LoansApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoansApplication.class, args);
	}

}
