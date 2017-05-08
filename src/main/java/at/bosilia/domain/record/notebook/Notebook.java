package at.bosilia.domain.record.notebook;

import at.bosilia.domain.record.Category;
import at.bosilia.domain.record.Record;
import at.bosilia.domain.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("NB")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notebook extends Record {

    @OneToMany(mappedBy = "notebook")
    private final List<Note> notes = new ArrayList<>();
    @Max(value = 100)
    private String description;

    public Notebook(User author, String title, Category category, String description) {
        super(author, title, category);
        this.description = description;
    }

    public void addNote(Note note) {
        notes.add(note);
        note.setNotebook(this);
    }
}
