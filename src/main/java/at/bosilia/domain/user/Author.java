package at.bosilia.domain.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Author extends User {

    private LocalDate lastLogin;

    public Author(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
