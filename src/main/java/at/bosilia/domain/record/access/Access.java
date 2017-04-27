package at.bosilia.domain.record.access;

import at.bosilia.domain.user.Author;
import at.bosilia.domain.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Access extends AbstractPersistable<Long> implements IAccess{

    private List<User> read;
    private List<Author> write;

    @Override
    public List<User> getReaders() {
        return read;
    }

    @Override
    public List<Author> getWriters() {
        return write;
    }
}
