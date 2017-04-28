package at.bosilia.domain.record.notebook;

import at.bosilia.domain.record.Record;
import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("N")
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Note extends Record{

    @NotNull @NonNull @Getter @Size(min = 1, max = 250)
    private String content;
    @ManyToOne(optional = false) @Setter
    private Notebook notebook;

    public void editContent(String content){
        this.content = content;
    }
}
