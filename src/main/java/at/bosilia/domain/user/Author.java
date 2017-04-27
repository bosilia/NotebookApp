package at.bosilia.domain.user;

import at.bosilia.domain.record.Record;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Author extends User {

    private LocalDate lastLogin;
    @OneToMany(mappedBy = "author")
    private List<Record> records;

    public Author(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void addRecord(Record record){
        this.records.add(record);
    }
}
