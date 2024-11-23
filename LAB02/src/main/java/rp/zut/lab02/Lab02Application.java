package rp.zut.lab02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Lab02Application {

	public static void main(String[] args) {
		log.info("STARTING THE APPLICATION");
		SpringApplication.run(Lab02Application.class, args);
	}

}
