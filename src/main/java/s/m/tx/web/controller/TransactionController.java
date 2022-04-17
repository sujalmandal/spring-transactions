package s.m.tx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s.m.tx.dto.TransactionRequestDTO;
import s.m.tx.dto.TransactionResponseDTO;
import s.m.tx.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    public ResponseEntity<Long> createTransaction(){
        return ResponseEntity.ok(this.transactionService.createTransaction());
    }

    @GetMapping("/{tx-id}")
    public ResponseEntity<TransactionResponseDTO> getTransaction(@PathVariable("tx-id") final Long txId){
        return ResponseEntity.ok(this.transactionService.getTransaction(txId));
    }

    @PatchMapping("/{tx-id}")
    public ResponseEntity<TransactionResponseDTO> updateTransaction(
            @PathVariable("tx-id") final Long txId, @RequestBody final TransactionRequestDTO requestDTO){
        return ResponseEntity.ok(this.transactionService.updateTransaction(txId, requestDTO));
    }

    @DeleteMapping("/")
    public ResponseEntity<Long> deleteTransaction(@PathVariable("tx-id") final Long txId){
        return ResponseEntity.ok(this.transactionService.deleteTransaction(txId));
    }
}
