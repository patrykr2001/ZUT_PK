package rp.zut.lab03.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Engine {
    private Oil oil;
    @Value("${engine.fuel.consumption}")
    private double fuelConsumption;

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    // wstrzyknięcie przez właściwość
    @Autowired
    public void setOil(Oil oil) {
        log.info("Wstrzykuję oil przez właściowść");
        this.oil = oil;
    }

    public void start() {
        log.info("Engine started");
    }
}