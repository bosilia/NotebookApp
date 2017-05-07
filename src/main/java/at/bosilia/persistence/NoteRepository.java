package at.bosilia.persistence;

import at.bosilia.domain.record.notebook.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findNotebooksByTitle(String title);

    List<Note> findNotebooksByTitleContaining(String title);
}
