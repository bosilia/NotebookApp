package at.bosilia.service

import at.bosilia.domain.record.Category
import at.bosilia.domain.record.notebook.Notebook
import at.bosilia.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration
class NotebookServiceTest extends Specification {

    @Autowired
    NotebookService notebookService
    @Autowired
    UserService userService
    @Autowired
    CategoryService categoryService
    final String STRING = "STRING"

    def "create valid account"() {
        setup: "test user and category"
        User user = userService.createUser(STRING, STRING).get()
        Category category = categoryService.createCategory(STRING, STRING).get()

        when: "creating account"
        Optional<Notebook> notebook = notebookService.createNotebook(user, STRING, category, STRING)

        then: "return value should be present"
        assert notebook.isPresent()
    }
}
