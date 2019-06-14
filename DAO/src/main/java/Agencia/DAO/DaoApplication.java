package Agencia.DAO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "Agencia.model")
@EnableJpaRepositories(basePackages = "Agencia.repo")
public class DaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaoApplication.class, args);
	}

}