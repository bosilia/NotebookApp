package at.bosilia.domain.user;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends AbstractPersistable<Long>{

    @OneToOne(optional = false, mappedBy = "account")
    private User user;
    @NotNull @NonNull @Size(min = 3, max = 20)
    private String accountName;
    private String salt;
    private String hash;

    public Account (String firstName, String lastName, String accountName){
        this.user = new User(firstName, lastName);
        this.accountName = accountName;
        //pw hash gen
        user.setAccount(this);
    }
}
