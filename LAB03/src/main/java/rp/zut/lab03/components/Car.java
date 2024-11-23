package rp.zut.lab03.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class Car {
    private Engine engine;
    private Transmission transmission;
    private String name;
    @Value("#{@engine.getFuelConsumption * ${car.route.lenght} / 100}")
    private Double roadFuelConsumption;

    // wstrzykiwanie zależności przez konstruktor
    public Car(Engine engine, Transmission transmission, String name) {
        log.info("Creating car " + name);
        this.engine = engine;
        this.transmission = transmission;
        this.name = name;
        log.info("TransmissionBeltLength: " + transmission.getTransmissionBeltLength());
    }

    public void run() {
        log.info("Running " + name);
        engine.start();
        log.info("Spalanie na trasie " + roadFuelConsumption);
    }
}
