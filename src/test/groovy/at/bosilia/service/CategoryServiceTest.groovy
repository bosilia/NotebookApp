package at.bosilia.service

import at.bosilia.domain.record.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration
class CategoryServiceTest extends Specification {

    @Autowired
    CategoryService categoryService
    final String STRING = "STRING"

    def "create valid category"() {
        when: "creating category"
        Optional<Category> category = categoryService.createCategory(STRING, STRING)

        then: "return value should be present"
        assert category.isPresent()
    }
}
