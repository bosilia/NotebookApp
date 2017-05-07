package at.bosilia.service;

import at.bosilia.domain.user.User;
import at.bosilia.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> createUser(String firstName, String lastName) {
        try {
            return Optional.of(userRepository.save(new User(firstName, lastName)));
        } catch (Exception e) {
            log.error(e.toString());
            return Optional.empty();
        }
    }
}
