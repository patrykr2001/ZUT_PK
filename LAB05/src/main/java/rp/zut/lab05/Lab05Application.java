package rp.zut.lab05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Slf4j
@PropertySource("classpath:app.properties")
public class Lab05Application {

	public static void main(String[] args) {
		log.info("STARTING THE APPLICATION");
		SpringApplication.run(Lab05Application.class, args);
	}

}
