package rp.zut.lab07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rp.zut.lab07.domain.CarOwner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
    @Query("SELECT c FROM CarOwner c WHERE c.lastName = :lastName")
    List<CarOwner> searchByLastName(@Param("lastName") String lastName);
}