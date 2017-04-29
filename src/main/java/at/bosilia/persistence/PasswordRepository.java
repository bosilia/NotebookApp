package at.bosilia.persistence;

import at.bosilia.domain.user.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {

    Optional<Password> findPasswordByHash (String hash);
}
