package at.bosilia.service;

import at.bosilia.domain.record.Category;
import at.bosilia.domain.record.task.Priority;
import at.bosilia.domain.record.task.Task;
import at.bosilia.domain.user.User;
import at.bosilia.persistence.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TaskService {

    private final TaskRepository taskRepository;

    public Optional<Task> createTask(User author, String title, Category category, LocalDate dueTo, String description,
                                     Priority priority) {
        try {
            return Optional.of(taskRepository.save(new Task(author, title, category, dueTo, description, priority)));
        } catch (Exception e) {
            log.error(e.toString());
            return Optional.empty();
        }
    }
}
