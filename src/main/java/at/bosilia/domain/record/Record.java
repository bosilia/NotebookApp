package at.bosilia.domain.record;

import at.bosilia.domain.record.access.IAccess;
import at.bosilia.domain.user.Author;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id; //TODO inheritance overhaul
    @ManyToOne(optional = false)
    private Author author;
    //@ManyToOne(optional = false) TODO: Think about implementation
    //private IAccess access;
    private String title;
    @ManyToOne(optional = false)
    private Category category;
    private LocalDate created;
    private LocalDate lastChanged;

    public Record(Author author, IAccess access, String title, Category category){
        this.id = title+2;
        this.author = author;
        //this.access = access;
        this.title = title;
        this.category = category;
        this.created = LocalDate.now();
        category.addRecords(this);
        author.addRecord(this);
    }

    public void hasChanged(){
        this.lastChanged = LocalDate.now();
    }
}
