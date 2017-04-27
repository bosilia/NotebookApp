package at.bosilia.domain.user;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends AbstractPersistable<Long>{

    @NotNull @NonNull
    private User user;
    @NotNull @NonNull
    private String accountName;
    private String salt;
    private String hash;

    public Account (User user, String accountName){
        this.user = user;
        this.accountName = accountName;
    }
}
