package s.m.tx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import s.m.tx.common.ErrorCode;
import s.m.tx.exception.AppException;
import s.m.tx.repository.TransactionRepo;

@Slf4j
@Service
public class InputValidationService {

    private final TransactionRepo transactionRepo;

    public InputValidationService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public void validateExistingTransaction(final Long id){
        log.info("is transaction active : {}", TransactionSynchronizationManager.isActualTransactionActive());
        transactionRepo.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.TX_NOT_FOUND.format(id)));
    }
}
