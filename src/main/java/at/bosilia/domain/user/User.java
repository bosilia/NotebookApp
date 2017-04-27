package at.bosilia.domain.user;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class User{

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private String id;

    @NonNull @NotNull
    private String firstName;
    @NonNull @NotNull
    private String lastName;
    private LocalDate created;
    @OneToOne @Setter
    private Account account;

    public User(String firstName, String lastName){
        this.id = firstName+lastName; //TODO: user account setup id generation overhaul
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = LocalDate.now();
    }
}
