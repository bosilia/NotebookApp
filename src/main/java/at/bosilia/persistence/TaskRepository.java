package at.bosilia.persistence;

import at.bosilia.domain.record.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findNotebooksByTitle (String title);
    List<Task> findNotebooksByTitleContaining (String title);
}
