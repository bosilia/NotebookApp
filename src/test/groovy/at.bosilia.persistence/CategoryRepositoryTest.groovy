package at.bosilia.persistence

import at.bosilia.domain.record.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration
class CategoryRepositoryTest extends Specification {

    @Autowired
    CategoryRepository categoryRepository
    Category category

    def setup() {
        category = new Category("Important", "an important category")
        categoryRepository.save(category)
    }

    def "FindCategoriesByDescriptionContaining"() {
        when:
        List<Category> res = categoryRepository.findCategoriesByDescriptionContaining("an")
        then:
        res.size() == 1
    }
}
