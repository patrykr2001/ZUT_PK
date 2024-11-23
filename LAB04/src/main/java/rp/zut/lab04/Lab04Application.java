package rp.zut.lab04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Slf4j
@PropertySource("classpath:app.properties")
public class Lab04Application {

	public static void main(String[] args) {
		log.info("STARTING THE APPLICATION");
		SpringApplication.run(Lab04Application.class, args);
	}

}
