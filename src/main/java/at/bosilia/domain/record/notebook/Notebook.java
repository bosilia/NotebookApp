package at.bosilia.domain.record.notebook;

import at.bosilia.domain.record.Record;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notebook extends Record {

    private String description;

    @OneToMany(mappedBy = "notebook")
    private List<Note> notes;

    public void addNote(Note note){
        notes.add(note);
        note.setNotebook(this);
    }
}
