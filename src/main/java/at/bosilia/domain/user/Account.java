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
public class Account extends AbstractPersistable<Long> {

    @OneToOne(optional = false, mappedBy = "account")
    private User user;
    @NotNull @NonNull @Size(min = 3, max = 20)
    private String accountName;
    private String salt;
    private String hash;

    public Account(User user, String accountName, String password) {
        this.user = user;
        this.accountName = accountName;
        //TODO has gen with password
        user.setAccount(this);
    }
}
