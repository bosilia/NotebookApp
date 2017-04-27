package at.bosilia.domain.record;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Category {

    @Id
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Record> records;

    public void addRecords(Record record){
        this.records.add(record);
    }
}
