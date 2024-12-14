package rp.zut.lab06;

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
@EnableJpaRepositories(basePackages = {"rp.zut.lab06.repository"})
@EntityScan("rp.zut.lab06.domain")
public class Lab06Application {
	public static void main(String[] args) {
		log.info("STARTING THE APPLICATION");
		SpringApplication.run(Lab06Application.class, args);
	}
}
