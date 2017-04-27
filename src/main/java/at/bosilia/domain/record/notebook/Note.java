package at.bosilia.domain.record.notebook;

import at.bosilia.domain.record.Record;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Note extends Record{
}
