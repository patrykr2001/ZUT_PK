package rp.zut.lab05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rp.zut.lab05.components.Car;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {
    // bezpośrednie wstrzyknięcie beana do pola
    @Autowired
    Car car;

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");
        try{
            car.run();
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("FINISH : command line runner");
    }
}
