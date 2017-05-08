package at.bosilia.service;

import at.bosilia.domain.record.Category;
import at.bosilia.domain.record.notebook.Notebook;
import at.bosilia.domain.user.User;
import at.bosilia.persistence.NotebookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class NotebookService {

    private final NotebookRepository notebookRepository;

    public Optional<Notebook> createNotebook(User author, String title, Category category, String description){
        try {
            return Optional.of(notebookRepository.save(new Notebook(author, title, category, description)));
        } catch (Exception e) {
            log.error(e.toString());
            return Optional.empty();
        }
    }
}
