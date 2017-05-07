package at.bosilia.persistence;

import at.bosilia.domain.user.Account;
import at.bosilia.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByUser(User user);

    Optional<Account> findAccountByAccountName(String accountName);

    List<Account> findAccountsByAccountNameContaining(String accountNameLike);
}
