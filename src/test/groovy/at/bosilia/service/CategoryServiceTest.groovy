package at.bosilia.service

import at.bosilia.domain.record.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Stepwise

@SpringBootTest
@ContextConfiguration
@Stepwise
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

    def "should return category"() {
        when: "name of existing category is searched"
        Optional<Category> category = categoryService.findCategoryByName(STRING)

        then: "return value should be present"
        assert category.isPresent()
    }
}
