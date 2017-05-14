package at.bosilia.domain.record.task;

import at.bosilia.domain.record.Category;
import at.bosilia.domain.record.Record;
import at.bosilia.domain.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("T")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task extends Record {

    private LocalDate dueTo;
    private String description;
    private Priority priority;

    public Task(User author, String title, Category category, LocalDate dueTo, String description, Priority priority) {
        super(author, title, category);
        this.dueTo = dueTo;
        this.description = description;
        this.priority = priority;
    }
}
