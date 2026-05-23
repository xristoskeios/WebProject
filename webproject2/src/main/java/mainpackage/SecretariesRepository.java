package mainpackage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecretariesRepository extends JpaRepository<Secretaries, Long>{


    Optional<Secretaries> findByUsername(String username);
}
