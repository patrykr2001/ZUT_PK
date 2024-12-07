package rp.zut.lab05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rp.zut.lab05.components.Car;
import rp.zut.lab05.components.Engine;
import rp.zut.lab05.components.Oil;
import rp.zut.lab05.components.Transmission;
import rp.zut.lab05.dao.CarDao;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    CarDao carDao;

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");

        // Sample data
        Engine engine = new Engine();
        engine.setFuelConsumption(8.5);
        Oil oil = new Oil();
        oil.setName("Synthetic Oil");
        engine.setOil(oil);

        Transmission transmission = new Transmission();
        transmission.setTransmissionBeltLength(1.5);

        Car sampleCar = new Car(engine, transmission, "Sample Car");
        sampleCar.setRoadFuelConsumption(10.0);
        sampleCar.setRouteLength(100);

        // Call CarDao methods
        carDao.update(sampleCar);
        Car retrievedCar = carDao.findCarByName("Sample Car");
        log.info("Retrieved Car: " + retrievedCar.getName());

        carDao.delete(sampleCar);
    }
}
