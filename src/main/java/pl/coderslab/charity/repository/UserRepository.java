package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.MatchingUser;

public interface UserRepository extends JpaRepository<MatchingUser, Long> {
    MatchingUser findByEmail(String email);
    boolean existsByEmail(String email);
}
