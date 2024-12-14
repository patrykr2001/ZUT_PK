package rp.zut.lab06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rp.zut.lab06.domain.PureCar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PureCarRepository extends JpaRepository<PureCar, Long> {
    @Query("SELECT p FROM PureCar p WHERE p.registrationNumber = :registrationNumber")
    List<PureCar> searchByRegistrationNumber(@Param("registrationNumber") String registrationNumber);
}