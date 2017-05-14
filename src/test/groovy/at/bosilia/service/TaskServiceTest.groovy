package at.bosilia.service

import at.bosilia.domain.record.Category
import at.bosilia.domain.record.task.Priority
import at.bosilia.domain.record.task.Task
import at.bosilia.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.time.LocalDate

@SpringBootTest
@ContextConfiguration
class TaskServiceTest extends Specification {

    @Autowired
    TaskService taskService
    @Autowired
    UserService userService
    @Autowired
    CategoryService categoryService
    final String STRING = "STRING"

    def "create valid task"() {
        setup: "test user and category"
        User user = userService.createUser(STRING, STRING).get()
        Category category = categoryService.createCategory(STRING, STRING).get()

        when: "creating task"
        Optional<Task> task = taskService.createTask(user, STRING, category, LocalDate.now(), STRING, Priority.LOW)

        then: "return value should be present"
        assert task.isPresent()
    }
}
