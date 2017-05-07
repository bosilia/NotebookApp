package at.bosilia.service

import at.bosilia.domain.user.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration
class AccountServiceTest extends Specification {

    @Autowired
    AccountService accountService
    final String STRING = "STRING"

    def "create valid account"() {
        when: "creating account"
        Optional<Account> account = accountService.createAccount(STRING, STRING, STRING, STRING)

        then: "return value should be present"
        assert account.isPresent()
    }
}
