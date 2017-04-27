package at.bosilia.domain.record;

import at.bosilia.domain.record.access.IAccess;
import at.bosilia.domain.user.Author;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Record extends AbstractPersistable<Long> {

    private Author author; //1:n
    private IAccess access; //1:n
    private String title;
    private Category category;
    private LocalDate created;
    private LocalDate lastChanged;
}
