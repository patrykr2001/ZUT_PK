package rp.zut.lab04.components;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import rp.zut.lab04.exceptions.EngineNotStartedException;

import java.util.Random;

@Component
@Slf4j
public class Engine {
    private Oil oil;
    @Getter
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
            throw new EngineNotStartedException("Engine failed to start");
        }
        log.info("Engine started");
    }
}