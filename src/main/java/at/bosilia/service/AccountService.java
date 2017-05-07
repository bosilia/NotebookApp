package at.bosilia.service;

import at.bosilia.domain.user.Account;
import at.bosilia.domain.user.User;
import at.bosilia.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService;

    public Optional<Account> createAccount(String firstName, String lastName, String accountName, String password) {

        Optional<User> user = userService.createUser(firstName, lastName);

        if (user.isPresent()) {
            try {
                return Optional.of(accountRepository.save(new Account(user.get(), accountName, password)));
            } catch (Exception e) {
                log.error(e.toString());
            }
        }
        return Optional.empty();
    }
}
