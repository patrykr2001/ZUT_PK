package rp.zut.lab08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rp.zut.lab08.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}