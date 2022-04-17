package s.m.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s.m.tx.common.JsonProcessor;
import s.m.tx.dto.TransactionRequestDTO;
import s.m.tx.dto.TransactionResponseDTO;
import s.m.tx.entity.Transaction;
import s.m.tx.entity.TransactionData;
import s.m.tx.repository.TransactionDataRepo;
import s.m.tx.repository.TransactionRepo;

import java.util.Map;
import java.util.Optional;


@Service
public class TransactionService {

    final private TransactionRepo txRepo;
    final private TransactionDataRepo txDataRepo;
    final private InputValidationService inputValidationService;
    final private JsonProcessor jsonProcessor;

    @Autowired
    public TransactionService(
            TransactionRepo txRepo, TransactionDataRepo txDataRepo, InputValidationService inputValidationService,
            JsonProcessor jsonProcessor) {
        this.txRepo = txRepo;
        this.txDataRepo = txDataRepo;
        this.inputValidationService = inputValidationService;
        this.jsonProcessor = jsonProcessor;
    }

    @Transactional
    public Long createTransaction() {
        Transaction tx = new Transaction();
        this.txRepo.save(tx);
        tx.setStatus(Transaction.Status.PENDING);
        return tx.getId();
    }

    public TransactionResponseDTO getTransaction(Long txId) {
        inputValidationService.validateExistingTransaction(txId);
        Optional<Transaction> transactionOpt = this.txRepo.findById(txId);
        Transaction tx = transactionOpt.get();
        String jsonData = tx.getData().getJsonData();
        return TransactionResponseDTO.builder()
                .transactionData(jsonProcessor.toPOJO(jsonData,Map.class))
                .status(tx.getStatus())
                .build();
    }

    @Transactional
    public TransactionResponseDTO updateTransaction(Long txId, TransactionRequestDTO requestDTO) {
        inputValidationService.validateExistingTransaction(txId);
        Transaction tx = this.txRepo.findById(txId).get();
        tx.setStatus(Transaction.Status.IN_PROGRESS);
        TransactionData data = new TransactionData();
        txDataRepo.save(data);
        data.setTransaction(tx);
        String jsonData = jsonProcessor.fromPOJO(requestDTO.getData());
        data.setJsonData(jsonData);
        return TransactionResponseDTO.builder()
                .id(tx.getId())
                .status(tx.getStatus())
                .transactionData(requestDTO.getData())
                .build();
    }

    @Transactional
    public Long deleteTransaction(Long txId) {
        inputValidationService.validateExistingTransaction(txId);
        Transaction tx = this.txRepo.findById(txId).get();
        tx.setIsActive(Boolean.FALSE);
        return tx.getId();
    }
}
