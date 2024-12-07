package rp.zut.lab05.components;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class Car {
    private Engine engine;
    private Transmission transmission;
    private String name;
    @Value("#{@engine.getFuelConsumption * ${car.route.lenght} / 100}")
    private Double roadFuelConsumption;
    @Getter
    @Value("${car.route.lenght}")
    private int routeLength;

    // wstrzykiwanie zależności przez konstruktor
    public Car(Engine engine, Transmission transmission, String name) {
        log.info("Creating car " + name);
        this.engine = engine;
        this.transmission = transmission;
        this.name = name;
        log.info("TransmissionBeltLength: " + transmission.getTransmissionBeltLength());
    }

    public void run() throws InterruptedException {
        log.info("Running " + name);
        engine.start();
        Thread.sleep(routeLength * 1000);
        log.info("Spalanie na trasie " + roadFuelConsumption);
    }
}
