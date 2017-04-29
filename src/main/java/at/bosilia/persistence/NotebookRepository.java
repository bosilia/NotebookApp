package at.bosilia.persistence;

import at.bosilia.domain.record.notebook.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {

    List<Notebook> findNotebooksByTitle (String title);
    List<Notebook> findNotebooksByTitleContaining (String title);
}
