package at.bosilia.domain.user;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class User extends AbstractPersistable<Long>{

    @NonNull @NotNull
    private String firstName;
    @NonNull @NotNull
    private String lastName;
    private LocalDate created;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = LocalDate.now();
    }
}
