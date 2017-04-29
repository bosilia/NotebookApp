package at.bosilia.persistence;

import at.bosilia.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUsersByFirstName (String firstName);
    List<User> findUsersByLastName (String lastName);
    List<User> findUsersByFirstNameAndLastName(String firstName, String lastName);
}
