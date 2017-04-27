package at.bosilia.domain.record.notebook;

import at.bosilia.domain.record.Record;
import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Note extends Record{

    @NotNull @NonNull @Getter
    private String content;
    @ManyToOne(optional = false) @Setter
    private Notebook notebook;

    public void editContent(String content){
        this.content = content;
    }
}
