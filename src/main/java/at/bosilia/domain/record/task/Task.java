package at.bosilia.domain.record.task;

import at.bosilia.domain.record.Record;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task extends Record {

    private LocalDate dueTo;
    private String description;
    private Priority priority;
}
