package s.m.tx.dto;

import lombok.Builder;
import lombok.Getter;
import s.m.tx.entity.Transaction;

import java.util.Map;

@Getter
@Builder
public class TransactionRequestDTO {
    private Transaction.Status status;
    private Map<String,String> data;
}
