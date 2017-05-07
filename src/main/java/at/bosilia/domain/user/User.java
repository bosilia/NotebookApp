package at.bosilia.domain.user;

import at.bosilia.domain.record.Record;
import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends AbstractPersistable<Long> {

    @OneToMany(mappedBy = "author")
    private final List<Record> records = new ArrayList<>();
    @NonNull @NotNull @Size(min = 1, max = 20)
    private String firstName;
    @NonNull @NotNull @Size(min = 1, max = 20)
    private String lastName;
    private LocalDate created;
    private LocalDate lastLogin;
    @OneToOne
    @Setter
    private Account account;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = LocalDate.now();
    }

    public void addRecord(Record record) {
        this.records.add(record);
    }
}
