package at.bosilia.domain.record;

import at.bosilia.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class Record extends AbstractPersistable<Long>{

    @ManyToOne(optional = false)
    private User author;
    @NotNull @NonNull @Size(min = 1, max = 25)
    private String title;
    @ManyToOne(optional = false)
    private Category category;
    private LocalDate created;
    private LocalDate lastChanged;

    public Record(User author, String title, Category category){
        this.author = author;
        this.title = title;
        this.category = category;
        this.created = LocalDate.now();
        author.addRecord(this);
        category.addRecords(this);
    }

    public void hasChanged(){
        this.lastChanged = LocalDate.now();
    }
}
