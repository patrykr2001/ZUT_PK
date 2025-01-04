package rp.zut.lab07;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import rp.zut.lab07.domain.CarOwner;
import rp.zut.lab07.domain.PureCar;
import rp.zut.lab07.repository.CarOwnerRepository;
import rp.zut.lab07.repository.PureCarRepository;

import java.util.List;

@Slf4j
@Component
@Transactional
public class AppRunner implements CommandLineRunner {
    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Autowired
    private PureCarRepository pureCarRepository;

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");

        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            log.info("Transaction is active");
        } else {
            log.info("Transaction is not active");
        }

        // Add a CarOwner
        CarOwner owner = new CarOwner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
        carOwnerRepository.save(owner);

        // Add a PureCar
        PureCar car = new PureCar();
        car.setRegistrationNumber("ABC123");
        car.setMark("Toyota");
        car.setName("Corolla");
        car.setType("Sedan");
        car.setOwner(owner);
        pureCarRepository.save(car);

        // Search for PureCar by registration number
        List<PureCar> cars = pureCarRepository.searchByRegistrationNumber("ABC123");
        log.info("Found cars: " + cars);

        // Search for CarOwner by last name
        List<CarOwner> owners = carOwnerRepository.searchByLastName("Doe");
        log.info("Found owners: " + owners);

        // Delete the PureCar
        pureCarRepository.delete(car);

        // Delete the CarOwner
        carOwnerRepository.delete(owner);
    }
}
