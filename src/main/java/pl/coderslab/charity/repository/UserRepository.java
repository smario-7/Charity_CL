package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.CharityUser;

public interface UserRepository extends JpaRepository<CharityUser, Long> {
    CharityUser findByEmail(String email);
    boolean existsByEmail(String email);
}
