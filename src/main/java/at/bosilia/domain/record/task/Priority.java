package at.bosilia.domain.record.task;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
enum Priority {

    HIGH("This is very important!"), MEDIUM("This is neither important nor unimportant"),
    LOW("This is unimportant.");

    @Getter @NotNull @NonNull
    private String description;

}
