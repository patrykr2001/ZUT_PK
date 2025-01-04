package rp.zut.lab07;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"rp.zut.lab07.repository"})
@EntityScan("rp.zut.lab07.domain")
public class Lab07Application {
	public static void main(String[] args) {
		log.info("STARTING THE APPLICATION");
		SpringApplication.run(Lab07Application.class, args);
	}
}
