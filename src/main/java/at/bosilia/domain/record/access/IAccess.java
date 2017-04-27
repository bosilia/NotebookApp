package at.bosilia.domain.record.access;

import at.bosilia.domain.user.Author;
import at.bosilia.domain.user.User;

import java.util.List;

public interface IAccess {

    List<User> getReaders();

    List<Author> getWriters();
}
