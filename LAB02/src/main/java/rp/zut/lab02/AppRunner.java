package rp.zut.lab02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rp.zut.lab02.components.Car;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {
    // bezpośrednie wstrzyknięcie beana do pola
    @Autowired
    Car car;

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");
        car.run();
        log.info("FINISH : command line runner");
    }
}
