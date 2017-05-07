package at.bosilia.service

import at.bosilia.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.transaction.Transactional

@SpringBootTest
@ContextConfiguration
@Transactional
class UserServiceTest extends Specification {

    @Autowired
    UserService userService
    final String STRING = "STRING"

    def "CreateUser"() {
        when: "creating user"
        Optional<User> user = userService.createUser(STRING, STRING)

        then: "return value should be present"
        assert user.isPresent()
    }
}
