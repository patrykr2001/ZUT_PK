package rp.zut.lab07.components;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
@Slf4j
public class Engine {
    @Setter
    private int id;
    private Oil oil;
    @Setter
    @Value("${engine.fuel.consumption}")
    private double fuelConsumption;

    // wstrzyknięcie przez właściwość
    @Autowired
    public void setOil(Oil oil) {
        log.info("Wstrzykuję oil przez właściowść");
        this.oil = oil;
    }

    public void start() {
        Random random = new Random();
        if (random.nextBoolean()) {
//            throw new EngineNotStartedException("Engine failed to start");
        }
        log.info("Engine started");
    }
}