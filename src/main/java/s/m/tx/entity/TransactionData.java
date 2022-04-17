package s.m.tx.entity;

import lombok.Getter;
import lombok.Setter;
import s.m.tx.entity.base.AuditableEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="transaction_data")
public class TransactionData extends AuditableEntity {

    @Column(name="json_data")
    private String jsonData;

    @OneToOne
    @JoinColumn(name = "tx_id",referencedColumnName = "id")
    private Transaction transaction;
}
