package rp.zut.lab09.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rp.zut.lab09.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}