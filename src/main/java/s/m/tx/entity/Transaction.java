package s.m.tx.entity;

import lombok.Getter;
import lombok.Setter;
import s.m.tx.entity.base.AuditableEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name  = "transaction")
public class Transaction extends AuditableEntity {

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(mappedBy = "transaction")
    private TransactionData data;

    private Boolean isActive = Boolean.TRUE;

    public static enum Status{
        PENDING,
        IN_PROGRESS,
        FAILED,
        SUCCESS
    }
}
