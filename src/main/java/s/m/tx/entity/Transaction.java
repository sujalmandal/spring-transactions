package s.m.tx.entity;

import lombok.Getter;
import lombok.Setter;
import s.m.tx.entity.base.AuditableEntity;

import javax.persistence.*;

@Entity
@Table(name  = "transaction")
@Getter
@Setter
public class Transaction extends AuditableEntity {

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="json_data")
    private String jsonData;

    public static enum Status{
        PENDING,
        IN_PROGRESS,
        FAILED,
        SUCCESS
    }
}
