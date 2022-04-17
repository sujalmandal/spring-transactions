package s.m.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s.m.tx.entity.Transaction;
import s.m.tx.entity.TransactionData;

@Repository
public interface TransactionDataRepo extends JpaRepository<TransactionData,Long> {
}
