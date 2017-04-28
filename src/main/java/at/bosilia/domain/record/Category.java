package at.bosilia.domain.record;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Category {

    @Id
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private final List<Record> records = new ArrayList<>();

    public void addRecords(Record record){
        this.records.add(record);
    }
}
