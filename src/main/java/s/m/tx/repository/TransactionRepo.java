package s.m.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s.m.tx.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {}