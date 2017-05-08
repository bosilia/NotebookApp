package at.bosilia.service;

import at.bosilia.domain.record.Category;
import at.bosilia.persistence.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Optional<Category> createCategory(String name, String description){
        try {
            return Optional.of(categoryRepository.save(new Category(name, description)));
        } catch (Exception e) {
            log.error(e.toString());
            return Optional.empty();
        }
    }

    public Optional<Category> findCategoryByName(String name){
        return categoryRepository.findCategoryByName(name);
    }
}
